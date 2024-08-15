package IFG.DAOs;
import static java.util.Optional.ofNullable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import IFG.Banco;
import IFG.Class.Raca;
import IFG.Class.Tipo;
import IFG.DAOs.iDAO.iRacaDAO;

public class RacaDAO implements iRacaDAO{
    @Override
    public Raca saverac(Raca raca) {
        try (Connection connection = Banco.getConnection()) {
            String sql = "INSERT INTO raca (nome, descricao, idt) " +
                         "VALUES (?, ? , ?)";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, raca.getNome());
            preparedStatement.setString(2, raca.getDescricao());
            preparedStatement.setLong(3, raca.getTipo().getId());
            preparedStatement.executeUpdate();
        
            try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                if (keys.next()) {

                    
                    raca.setId(keys.getLong(1));

                }
                else {
                   
                    throw new SQLException("Nenhum id foi gerado.");
                }
            }
            preparedStatement.close();
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return raca;
    }

    @Override
    public Raca updaterac(Raca raca) {
        try (Connection connection = Banco.getConnection()) {
            String sql = "UPDATE raca " +
                         "SET nome=?, descricao=?, idt=? " + 
                         "WHERE id=?";
            
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            // Definindo os parâmetros
            preparedStatement.setString(1, raca.getNome());
            preparedStatement.setString(2, raca.getDescricao());
            preparedStatement.setLong(3, raca.getTipo().getId());  
            preparedStatement.setLong(4, raca.getId()); 
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return raca;
    }

    @Override
    public void deleterac(Long id) {
        try (Connection connection = Banco.getConnection()) {
            String sql = "DELETE FROM raca WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    } 

    @Override
    public Optional<Raca> findByIdrac(Long id) {
        String sql = "SELECT * FROM raca WHERE id = ?";
        Raca raca = null;
        try (Connection connection = Banco.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    raca = new Raca();
                    Raca fRaca = raca;
                    raca.setId(resultSet.getLong("id"));
                    raca.setNome("nome");
                    raca.setDescricao("descricao");
                    Tipo tipo = new Tipo();
                    tipo.setId(resultSet.getLong("idt"));
                    

                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                preparedStatement.close();
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return ofNullable(raca);
    }
    
    @Override
    public Optional<Raca> findByNorac(String nome) {
        String sql = "SELECT * FROM raca WHERE nome = ?";
        Raca raca = null;
        try (Connection connection = Banco.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    raca = new Raca();
                    Raca fRaca = raca;
                    raca.setId(resultSet.getLong("id"));
                    raca.setNome("nome");
                    raca.setDescricao("descricao");
                    Tipo tipo = new Tipo();
                    tipo.setId(resultSet.getLong("idt"));
                    

                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                preparedStatement.close();
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return ofNullable(raca);
    }

    @Override
    public List<Raca> findAllrac() {
        List<Raca> racas = new ArrayList<>();
        String sql = "SELECT * FROM raca"; 

        try (Connection connection = Banco.getConnection()) {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Raca raca = new Raca();
                    raca.setId(resultSet.getLong("id")); 
                    raca.setNome(resultSet.getString("nome"));
                    raca.setDescricao(resultSet.getString("descricao")); 
                    Tipo tipo = new Tipo();
                    tipo.setId(resultSet.getLong("idt"));
                    raca.setTipo(tipo);
                    racas.add(raca);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                preparedStatement.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return racas;
    }



}