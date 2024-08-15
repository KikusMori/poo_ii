package IFG.DAOs;
import IFG.Banco;
import IFG.Class.Pessoa;
import IFG.DAOs.iDAO.iPessoaDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class PessoaDAO implements iPessoaDAO{
    @Override
    public Pessoa savepes(Pessoa pessoa) {
        try (Connection connection = Banco.getConnection()) {
            String sql = "INSERT INTO pessoa (nome, endereco, telefone, email, datanasc) " +
                         "VALUES (?, ?, ?, ?, ?)";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getEndereco());
            preparedStatement.setString(3, pessoa.getTelefone());
            preparedStatement.setString(4, pessoa.getEmail());
            preparedStatement.setString(5, pessoa.getData());
            preparedStatement.executeUpdate();
            
            try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                if (keys.next()) {

                   
                    pessoa.setId(keys.getLong(1));

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
        return pessoa;
    }

    @Override
    public void updatepes(Pessoa pessoa) {
        try (Connection connection = Banco.getConnection()) {

            String sql = "UPDATE pessoa " +
                         "SET nome=?, endereco=?, telefone=?, email=?, datanasc=? " +
                         "WHERE id=?";
            
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getEndereco());
            preparedStatement.setString(3, pessoa.getTelefone());
            preparedStatement.setString(4, pessoa.getEmail());
            preparedStatement.setString(5, pessoa.getData());
            preparedStatement.setLong(6, pessoa.getId());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
       
    }


    @Override
    public void deletepes(Long id) {
        try (Connection connection = Banco.getConnection()) {
            String sql = "DELETE FROM pessoa WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    } 

    @Override
    public Optional<Pessoa> findByIdpes(Long id) {
        String sql = "SELECT * FROM pessoa WHERE id = ?";
        Pessoa pessoa = null;
        try (Connection connection = Banco.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    pessoa = new Pessoa();
                    Pessoa fPessoa = pessoa;
                    pessoa.setId(resultSet.getLong("id"));
                    pessoa.setNome(resultSet.getString("nome"));
                    pessoa.setEndereco(resultSet.getString("endereco"));
                    pessoa.setTelefone(resultSet.getString("telefone"));
                    pessoa.setEmail(resultSet.getString("email"));
                    pessoa.setData(resultSet.getString("datanasc"));

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
        return ofNullable(pessoa);
    }
    
    @Override
    public Optional<Pessoa> findByEmpes(String email) {
        String sql = "SELECT * FROM pessoa WHERE email = ?";
        Pessoa pessoa = null;
        try (Connection connection = Banco.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    pessoa = new Pessoa();
                    Pessoa fPessoa = pessoa;
                    pessoa.setId(resultSet.getLong("id"));
                    pessoa.setNome(resultSet.getString("nome"));
                    pessoa.setEndereco(resultSet.getString("endereco"));
                    pessoa.setTelefone(resultSet.getString("telefone"));
                    pessoa.setEmail(resultSet.getString("email"));
                    pessoa.setData(resultSet.getString("datanasc"));

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
        return ofNullable(pessoa);
    }

    @Override
    public List<Pessoa> findAllpes() {
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM pessoa";
        try (Connection connection = Banco.getConnection()) {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Pessoa pessoa = new Pessoa();
                    pessoa.setId(resultSet.getLong("id"));
                    pessoa.setNome(resultSet.getString("nome"));
                    pessoa.setEndereco(resultSet.getString("endereco"));
                    pessoa.setTelefone(resultSet.getString("telefone"));
                    pessoa.setEmail(resultSet.getString("email"));
                    pessoa.setData(resultSet.getString("datanasc"));

                    pessoas.add(pessoa);
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
        return pessoas;
    }
}