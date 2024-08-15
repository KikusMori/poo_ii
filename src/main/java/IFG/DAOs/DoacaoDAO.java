package IFG.DAOs;
import IFG.Banco;
import IFG.Class.Doacao;
import IFG.Class.Pessoa;
import IFG.Class.Animal;
import IFG.DAOs.iDAO.iDoacaoDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class DoacaoDAO implements iDoacaoDAO{
    @Override
    public Doacao savedoa(Doacao doacao) {
        try (Connection connection = Banco.getConnection()) {
            String sql = "INSERT INTO doacao (estado, descricao, datadoa, datarec, ida, idp) " +
                         "VALUES (?, ?, ?, ?, ?, ?)";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, doacao.getEstado());
            preparedStatement.setString(2, doacao.getDescricao());
            preparedStatement.setString(3, doacao.getDatadoa());
            preparedStatement.setString(4, doacao.getDatarec());
            preparedStatement.setLong(5, doacao.getAnimal().getId());
            preparedStatement.setLong(6, doacao.getPessoa().getId());
            preparedStatement.executeUpdate();
           
            try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                if (keys.next()) {

                   
                    doacao.setId(keys.getLong(1));

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
        return doacao;
    }

    @Override
    public void updatedoa(Doacao doacao) {
        String sql = "UPDATE Doacao SET estado = ?, descricao = ?, datadoa = ?, datarec = ?, ida = ?, idp = ? WHERE id = ?";
        try (Connection connection = Banco.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
           
            preparedStatement.setString(1, doacao.getEstado());
            preparedStatement.setString(2, doacao.getDescricao());
            preparedStatement.setString(3, doacao.getDatadoa());
            preparedStatement.setString(4, doacao.getDatarec());
            preparedStatement.setLong(5, doacao.getAnimal().getId()); 
            preparedStatement.setLong(6, doacao.getPessoa().getId()); 
            preparedStatement.setLong(7, doacao.getId()); 
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


    @Override
    public void deletedoa(Long id) {
        try (Connection connection = Banco.getConnection()) {
            String sql = "DELETE FROM Doacao WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    } 

    @Override
    public Optional<Doacao> findByIddoa(Long id) {
        String sql = "SELECT * FROM Doacao WHERE id = ?";
        Doacao Doacao = null;
        try (Connection connection = Banco.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Doacao = new Doacao();
                    Doacao fDoacao = Doacao;
                    Doacao.setId(resultSet.getLong("id"));
                    Doacao.setEstado(resultSet.getString("estado"));
                    Doacao.setDescricao(resultSet.getString("descricao"));
                    Doacao.setDatadoa(resultSet.getString("datadoa"));
                    Doacao.setDatarec(resultSet.getString("datarec"));
                    Animal animal = new Animal();
                    animal.setId(resultSet.getLong("ida"));
                    Pessoa pessoa = new Pessoa();
                    pessoa.setId(resultSet.getLong("idp"));

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
        return ofNullable(Doacao);
    }

   
    @Override
    public List<Doacao> findAlldoa() {
        List<Doacao> doacaos = new ArrayList<>();
        String sql = "SELECT * FROM Doacao";
        try (Connection connection = Banco.getConnection()) {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Doacao doacao = new Doacao();
                    doacao.setId(resultSet.getLong("id"));
                    doacao.setEstado(resultSet.getString("estado"));
                    doacao.setDescricao(resultSet.getString("descricao"));
                    doacao.setDatadoa(resultSet.getString("datadoa"));
                    doacao.setDatarec(resultSet.getString("datarec"));

                   
                    Animal animal = new Animal();
                    animal.setId(resultSet.getLong("ida"));
                    doacao.setAnimal(animal);

                    
                    Pessoa pessoa = new Pessoa();
                    pessoa.setId(resultSet.getLong("idp"));
                    doacao.setPessoa(pessoa);

                    doacaos.add(doacao);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                preparedStatement.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return doacaos;
    }

}