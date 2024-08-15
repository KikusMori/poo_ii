package IFG.DAOs;
import IFG.Banco;
import IFG.Class.Consulta;
import IFG.Class.Pessoa;
import IFG.Class.Raca;
import IFG.Class.Animal;
import IFG.Class.Veterinario;
import IFG.DAOs.iDAO.iConsultaDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class ConsultaDAO implements iConsultaDAO{
    @Override
    public Consulta savecon(Consulta Consulta) {
        try (Connection connection = Banco.getConnection()) {
            String sql = "INSERT INTO Consulta (diagnostico, data, ida, idv) " +
                         "VALUES (?, ?, ?, ?)";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, Consulta.getDiagnostico());
            preparedStatement.setString(2, Consulta.getData());
            preparedStatement.setLong(3, Consulta.getAnimal().getId());
            preparedStatement.setLong(4, Consulta.getVet().getId());
            preparedStatement.executeUpdate();
           
            try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                if (keys.next()) {

                   
                    Consulta.setId(keys.getLong(1));

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
        return Consulta;
    }

    @Override
    public void updatecon(Consulta consulta) {
        String sql = "UPDATE Consulta SET diagnostico = ?, data = ?, ida = ?, idv = ? WHERE id = ?";
        try (Connection connection = Banco.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
          
            preparedStatement.setString(1, consulta.getDiagnostico());
            preparedStatement.setString(2, consulta.getData());
            preparedStatement.setLong(3, consulta.getAnimal().getId()); 
            preparedStatement.setLong(4, consulta.getVet().getId());
            preparedStatement.setLong(5, consulta.getId()); 
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void deletecon(Long id) {
        try (Connection connection = Banco.getConnection()) {
            String sql = "DELETE FROM Consulta WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    } 

    @Override
    public Optional<Consulta> findByIdcon(Long id) {
        String sql = "SELECT * FROM Consulta WHERE id = ?";
        Consulta Consulta = null;
        try (Connection connection = Banco.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Consulta = new Consulta();
                    Consulta fConsulta = Consulta;
                    Consulta.setId(resultSet.getLong("id"));
                    Consulta.setDiagnostico(resultSet.getString("diagnostico"));
                    Consulta.setData(resultSet.getString("data"));
                    Animal animal = new Animal();
                    animal.setId(resultSet.getLong("ida"));
                    Veterinario veterinario = new Veterinario();
                    veterinario.setId(resultSet.getLong("idv"));

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
        return ofNullable(Consulta);
    }

    @Override
    public List<Consulta> findAllcon() {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT * FROM Consulta";
        try (Connection connection = Banco.getConnection()) {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Consulta consulta = new Consulta();
                    consulta.setId(resultSet.getLong("id"));
                    consulta.setDiagnostico(resultSet.getString("diagnostico"));
                    consulta.setData(resultSet.getString("data"));

                    Animal animal = new Animal();
                    animal.setId(resultSet.getLong("ida"));
                    consulta.setAnimal(animal);

                    Veterinario veterinario = new Veterinario();
                    veterinario.setId(resultSet.getLong("idv"));
                    consulta.setVet(veterinario);

                    consultas.add(consulta);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                preparedStatement.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return consultas;
    }

}