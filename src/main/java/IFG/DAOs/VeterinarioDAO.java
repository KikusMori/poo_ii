package IFG.DAOs;
import IFG.Banco;
import IFG.Class.Veterinario;
import IFG.DAOs.iDAO.iVeterinarioDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class VeterinarioDAO implements iVeterinarioDAO{
    @Override
    public Veterinario savevet(Veterinario veterinario) {
        try (Connection connection = Banco.getConnection()) {
            String sql = "INSERT INTO veterinario (nome, certificacao, local, especialidade) " +
                         "VALUES (?, ?, ?, ?)";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, veterinario.getNome());
            preparedStatement.setString(2, veterinario.getCerti());
            preparedStatement.setString(3, veterinario.getLocal());
            preparedStatement.setString(4, veterinario.getEsp());
            preparedStatement.executeUpdate();
        
            try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                if (keys.next()) {

                   
                    veterinario.setId(keys.getLong(1));

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
        return veterinario;
    }

    @Override
    public Veterinario updatevet(Veterinario veterinario) {
        try (Connection connection = Banco.getConnection()) {
            String sql = "UPDATE veterinario " +
                         "SET nome=?, certificacao=?, local=?, especialidade=? " +
                         "WHERE id=?";
            
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
      
            preparedStatement.setString(1, veterinario.getNome());
            preparedStatement.setString(2, veterinario.getCerti());
            preparedStatement.setString(3, veterinario.getLocal()); 
            preparedStatement.setString(4, veterinario.getEsp());
            preparedStatement.setLong(5, veterinario.getId());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return veterinario;
    }


    @Override
    public void deletevet(Long id) {
        try (Connection connection = Banco.getConnection()) {
            String sql = "DELETE FROM veterinario WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    } 
    @Override
    public Optional<Veterinario> findByIdvet(Long id) {
        String sql = "SELECT * FROM veterinario WHERE id = ?";
        Veterinario veterinario = null;
        try (Connection connection = Banco.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    veterinario = new Veterinario();
                    Veterinario fVeterinario = veterinario;
                    veterinario.setId(resultSet.getLong("id"));
                    veterinario.setNome(resultSet.getString("nome"));
                    veterinario.setCerti(resultSet.getString("certificacao"));
                    veterinario.setLocal(resultSet.getString("local"));
                    veterinario.setEsp(resultSet.getString("especialidade"));
                    

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
        return ofNullable(veterinario);
    }
    
    @Override
    public Optional<Veterinario> findByNovet(String nome) {
        String sql = "SELECT * FROM veterinario WHERE nome = ?";
        Veterinario veterinario = null;
        try (Connection connection = Banco.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    veterinario = new Veterinario();
                    Veterinario fVeterinario = veterinario;
                    veterinario.setId(resultSet.getLong("id"));
                    veterinario.setNome(resultSet.getString("nome"));
                    veterinario.setCerti(resultSet.getString("certificacao"));
                    veterinario.setLocal(resultSet.getString("local"));
                    veterinario.setEsp(resultSet.getString("especialidade"));
                    

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
        return ofNullable(veterinario);
    }

    @Override
    public List<Veterinario> findAllvet() {
        List<Veterinario> veterinarios = new ArrayList<>();
        String sql = "SELECT * FROM veterinario";
        try (Connection connection = Banco.getConnection()) {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Veterinario veterinario = new Veterinario();
                    veterinario.setId(resultSet.getLong("id"));
                    veterinario.setNome(resultSet.getString("nome"));
                    veterinario.setCerti(resultSet.getString("certificacao"));
                    veterinario.setLocal(resultSet.getString("local"));
                    veterinario.setEsp(resultSet.getString("especialidade"));
                    veterinarios.add(veterinario);
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
        return veterinarios;
    }
}