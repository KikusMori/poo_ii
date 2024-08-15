package IFG.DAOs;
import IFG.Banco;
import IFG.Class.Animal;
import IFG.Class.Pessoa;
import IFG.Class.Raca;
import IFG.DAOs.iDAO.iAnimalDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class AnimalDAO implements iAnimalDAO{
    @Override
    public void saveani(Animal animal) {
        try (Connection connection = Banco.getConnection()) {
            String sql = "INSERT INTO Animal (nome, datanasc, foto, doado, idade, idr, idp) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, animal.getNome());
            preparedStatement.setString(2, animal.getDatanasc());
            preparedStatement.setString(3, animal.getFoto());
            preparedStatement.setBoolean(4, animal.getDoado());
            preparedStatement.setInt(5, animal.getIdade());
            
            // Verificar se a raca não é null
            if (animal.getRaca() != null) {
                preparedStatement.setLong(6, animal.getRaca().getId());
            } else {
                throw new IllegalArgumentException("Raca cannot be null");
            }

            // Verificar se a pessoa não é null
            if (animal.getPessoa() != null) {
                preparedStatement.setLong(7, animal.getPessoa().getId());
            } else {
                throw new IllegalArgumentException("Pessoa cannot be null");
            }
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException | IllegalArgumentException ex) {
            throw new RuntimeException(ex);
        }
    }


    @Override
    public void updateani(Animal animal) {
        String sql = "UPDATE Animal SET nome = ?, datanasc = ?, foto = ?, doado = ?, idade = ?, idr = ?, idp = ? WHERE id = ?";
        try (Connection connection = Banco.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, animal.getNome());
            preparedStatement.setString(2, animal.getDatanasc());
            preparedStatement.setString(3, animal.getFoto());
            preparedStatement.setBoolean(4, animal.getDoado());
            preparedStatement.setInt(5, animal.getIdade());
            
           
            if (animal.getRaca() != null) {
                preparedStatement.setLong(6, animal.getRaca().getId());
            } else {
                throw new IllegalArgumentException("Raca cannot be null");
            }

            if (animal.getPessoa() != null) {
                preparedStatement.setLong(7, animal.getPessoa().getId());
            } else {
                throw new IllegalArgumentException("Pessoa cannot be null");
            }
            
            preparedStatement.setLong(8, animal.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException | IllegalArgumentException ex) {
            throw new RuntimeException(ex);
        }
    }


    @Override
    public void deleteani(Long id) {
        try (Connection connection = Banco.getConnection()) {
            String sql = "DELETE FROM Animal WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    } 

    @Override
    public Optional<Animal> findByIdani(Long id) {
        String sql = "SELECT * FROM Animal WHERE id = ?";
        Animal Animal = null;
        try (Connection connection = Banco.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Animal = new Animal();
                    Animal fAnimal = Animal;
                    Animal.setId(resultSet.getLong("id"));
                    Animal.setNome(resultSet.getString("nome"));
                    Animal.setDatanasc(resultSet.getString("datanasc"));
                    Animal.setFoto(resultSet.getString("foto"));
                    Animal.setDoado(resultSet.getBoolean("doado"));
                    Animal.setIdade(resultSet.getInt("idade"));
                    Raca raca = new Raca();
                    raca.setId(resultSet.getLong("idr"));
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
        return ofNullable(Animal);
    }
    
    @Override
    public Optional<Animal> findByNani(String nome) {
        String sql = "SELECT * FROM Animal WHERE nome = ?";
        Animal Animal = null;
        try (Connection connection = Banco.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Animal = new Animal();
                    Animal fAnimal = Animal;
                    Animal.setId(resultSet.getLong("id"));
                    Animal.setNome(resultSet.getString("nome"));
                    Animal.setDatanasc(resultSet.getString("datanasc"));
                    Animal.setFoto(resultSet.getString("foto"));
                    Animal.setDoado(resultSet.getBoolean("doado"));
                    Animal.setIdade(resultSet.getInt("idade"));
                    Raca raca = new Raca();
                    raca.setId(resultSet.getLong("idr"));
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
        return ofNullable(Animal);
    }

    @Override
    public List<Animal> findAllani() {
        List<Animal> animals = new ArrayList<>();
        String sql = "SELECT * FROM Animal";
        try (Connection connection = Banco.getConnection()) {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Animal animal = new Animal();
                    animal.setId(resultSet.getLong("id"));
                    animal.setNome(resultSet.getString("nome"));
                    animal.setDatanasc(resultSet.getString("datanasc"));
                    animal.setFoto(resultSet.getString("foto"));
                    animal.setDoado(resultSet.getBoolean("doado"));
                    animal.setIdade(resultSet.getInt("idade"));

                  
                    Raca raca = new Raca();
                    raca.setId(resultSet.getLong("idr"));
                    animal.setRaca(raca);

                    Pessoa pessoa = new Pessoa();
                    pessoa.setId(resultSet.getLong("idp"));
                    animal.setPessoa(pessoa);

                    animals.add(animal);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                preparedStatement.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return animals;
    }

}