
package com.mycompany.zcondo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MoradorDAO {


    public Moradores getById (int id) throws SQLException{
        try {
            Connection connection = ConnectionSingleton.getConnection();       

            ResultSet resultMoradores = connection. //
                    createStatement().//
                    executeQuery("SELECT * FROM usuario WHERE codigo = " + id + ";");

            
            
            String nomeUser = resultMoradores.getString("nomeUser");
            String nascUser = resultMoradores.getString("nascUser");
            String cpfUser = resultMoradores.getString("cpfUser");
            String rgUser = resultMoradores.getString("rgUser");
            String numero_aptoUser = resultMoradores.getString("numero_aptoUser");
            String telefoneUser = resultMoradores.getString("telefoneUser");
            String emailUser = resultMoradores.getString("emailUser");

            return new Moradores (nomeUser, nascUser, cpfUser, rgUser, numero_aptoUser, telefoneUser, emailUser, 2 );

        } catch (Exception e){
                throw new RuntimeException (e);
            }   
    }


    public List<Moradores> getAll() {
           try {
               Connection connection = ConnectionSingleton.getConnection();
               ResultSet resultadoMoradores = connection. //
                       createStatement(). //
                       executeQuery("SELECT * FROM usuario");

               List<Moradores> listaDeMoradores = new ArrayList<>();

               while (!resultadoMoradores.isLast()) {
                   
                   resultadoMoradores.next();

                   String nomeUser = resultadoMoradores.getString("nomeUser");
                   String nascUser = resultadoMoradores.getString("nascUser");
                   String cpfUser = resultadoMoradores.getString("cpfUser");
                   String rgUser = resultadoMoradores.getString("rgUser");
                   String numero_aptoUser = resultadoMoradores.getString("numero_aptoUser");
                   String telefoneUser = resultadoMoradores.getString("telefoneUser");
                   String emailUser = resultadoMoradores.getString("emailUser");
                   int nivelUser = resultadoMoradores.getInt("nivelUser");

                   Moradores moradorResultadoDaBusca = new Moradores(nomeUser, nascUser, cpfUser, rgUser, numero_aptoUser, telefoneUser, emailUser, nivelUser );
                   listaDeMoradores.add(moradorResultadoDaBusca);
               }

               return listaDeMoradores;
               
           } catch (Exception e) {
               throw new RuntimeException(e);
           }
        }

    public void save(Moradores novoMorador) {
       try {
           Connection connection = ConnectionSingleton.getConnection();
           connection.createStatement(). //
                   executeUpdate("INSERT INTO usuario values (" //
                           + "1234, "      //Senha padrão
                           + "'" + novoMorador.nome  //
                                + "' , '" + novoMorador.dataDeNascimento + "'" //
                                        + ", '" + novoMorador.cpf+ "'" //
                                                + ", '" + novoMorador.rg+ "'" //
                                                        + ", '" + novoMorador.apartamento + "'" //
                                                                + ", '" + novoMorador.telefone + "'" //
                                                                    + ", '" + novoMorador.email + "'" //
                                                                      + ", " + 2 + " )"
                           
                   );
           
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }


    public void update(Moradores moradoresEdited) {
       try {
           Connection connection = ConnectionSingleton.getConnection();
           connection.createStatement(). //
                   executeUpdate("UPDATE usuario SET " //
                           + "nomeUser = '" + moradoresEdited.nome + "'" //
                                + ", nascUser = '" + moradoresEdited.dataDeNascimento  + "'"  //
                                    + ", cpfUser = '" + moradoresEdited.cpf + "'"  //

                                            + ", numero_aptoUser = '" + moradoresEdited.apartamento + "'"  //
                                                + ", telefoneUser = '" + moradoresEdited.telefone + "'"  //
                                                    + ", emailUser = '" + moradoresEdited.email + "'"  // 
                                                      +", nivelUser = " + 2//
                                                          + " WHERE rgUser = " + moradoresEdited.getRg() //
                   );  
           

       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }

    
    public void delete(Moradores moradoresToRemove) {
       try {
           Connection connection = ConnectionSingleton.getConnection();
           connection.createStatement(). //
                   executeUpdate("DELETE FROM usuario WHERE rgUser = '" + moradoresToRemove.rg + "'");
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }
    
    public boolean exists(Moradores usuario) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet resultadoUsuarioExiste = connection. //
                    createStatement(). //
                    executeQuery("select count(*) from usuario " //
                            + " where nomeUser = '" + usuario.getNome() + "'"//
                            + " and senhaUser = '" + usuario.getSenha() + "' ;");

            resultadoUsuarioExiste.next();
            int quantidadeDeUsuariosComEsseUsuarioESenha = resultadoUsuarioExiste.getInt(1);

            return quantidadeDeUsuariosComEsseUsuarioESenha > 0;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
