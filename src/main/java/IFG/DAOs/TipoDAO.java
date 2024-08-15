package IFG.DAOs;
import IFG.Banco;

import IFG.Class.Tipo;
import IFG.DAOs.iDAO.iTipoDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class TipoDAO implements iTipoDAO{
    @Override
    public Tipo savetip(Tipo tipo) {
        try (Connection connection = Banco.getConnection()) {
            String sql = "INSERT INTO tipo (nome) " +
                         "VALUES (?)";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, tipo.getNome());
            preparedStatement.executeUpdate();
    
            try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                if (keys.next()) {

                    
                    tipo.setId(keys.getLong(1));

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
        return tipo;
    }

    @Override
    public Tipo updatetip(Tipo tipo) {
        try (Connection connection = Banco.getConnection()) {
            String sql = "UPDATE tipo " +
                         "SET nome=? " + 
                         "WHERE id=?";
            
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
           
            preparedStatement.setString(1, tipo.getNome());
            preparedStatement.setLong(2, tipo.getId());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return tipo;
    }


    @Override
    public void deletetip(Long id) {
        try (Connection connection = Banco.getConnection()) {
            String sql = "DELETE FROM tipo WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    } 

    @Override
    public Optional<Tipo> findByIdtip(Long id) {
        String sql = "SELECT * FROM tipo WHERE id = ?";
        Tipo tipo = null;
        try (Connection connection = Banco.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    tipo = new Tipo();
                    Tipo fTipo = tipo;
                    tipo.setId(resultSet.getLong("id"));
                    tipo.setNome(resultSet.getString("nome"));
                    

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
        return ofNullable(tipo);
    }
    
    @Override
    public Optional<Tipo> findByNotip(String nome) {
        String sql = "SELECT * FROM tipo WHERE nome = ?";
        Tipo tipo = null;
        try (Connection connection = Banco.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    tipo = new Tipo();
                    Tipo fTipo = tipo;
                    tipo.setId(resultSet.getLong("id"));
                    tipo.setNome(resultSet.getString("nome"));
                    

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
        return ofNullable(tipo);
    }

    @Override
    public List<Tipo> findAlltip() {
        List<Tipo> tipos = new ArrayList<>();
        String sql = "SELECT * FROM tipo";
        try (Connection connection = Banco.getConnection()) {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Tipo tipo = new Tipo();
                    tipo.setId(resultSet.getLong("id"));
                    tipo.setNome(resultSet.getString("nome"));


                    tipos.add(tipo);
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
        return tipos;
    }


}