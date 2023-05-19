package com.example.proyecto_final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class EstadisticasBulls {

    @FXML
    private Button BotonUltimos2encuentros;

    @FXML
    private Button BotonVerEstadisticas;

    @FXML
    private Button BotonVolverAnteriores;

    @FXML
    private TextField SalidTemporadaAnterior2_11;

    @FXML
    private TextField SalidTemporadaAnterior2_2;

    @FXML
    private TextField SalidaGanadorAnterior;

    @FXML
    private TextField SalidaGanadorAnterior2_1;

    @FXML
    private TextField SalidaGanadorAnterior2_2;

    @FXML
    private TextField SalidaJugadorAnterior;

    @FXML
    private TextField SalidaJugadorAnterior2_1;

    @FXML
    private TextField SalidaJugadorAnterior2_2;

    @FXML
    private TextField SalidaPuntosAnterior;

    @FXML
    private TextField SalidaPuntosAnterior2_1;

    @FXML
    private TextField SalidaPuntosAnterior2_2;

    @FXML
    private TextField SalidaRebotesAnterior;

    @FXML
    private TextField SalidaRebotesAnterior2_1;

    @FXML
    private TextField SalidaRebotesAnterior2_2;

    @FXML
    private TextField SalidaTaponesAnterior;

    @FXML
    private TextField SalidaTaponesAnterior2_1;

    @FXML
    private TextField SalidaTaponesAnterior2_2;


    @FXML
    void PulsarBotonUtlimos2encuentros(ActionEvent event) {
            String []consultas2= new String[12];
        consultas2[0]="SELECT distinct equipo_local from partidos where puntos_local>puntos_visitante and equipo_local='Bulls' and equipo_visitante='Hornets' and temporada='98/99';";
        consultas2[1]="SELECT jugadores.Nombre /*estadisticas.jugador*/\n" +
                "                from jugadores inner join estadisticas natural join partidos\n" +
                "                on jugadores.codigo= estadisticas.jugador\n" +
                "                WHERE partidos.equipo_local = 'Bulls'\n" +
                "                  AND partidos.equipo_visitante = 'Hornets'\n" +
                "                  AND partidos.temporada = '98/99'\n" +
                "                  AND partidos.puntos_local > partidos.puntos_visitante\n" +
                "                  AND jugadores.codigo IN (\n" +
                "                    SELECT estadisticas.jugador\n" +
                "                     FROM estadisticas\n" +
                "                         natural join partidos\n" +
                "                    WHERE partidos.equipo_local = 'Bulls'\n" +
                "                      AND partidos.equipo_visitante = 'Hornets'\n" +
                "                      AND partidos.temporada = '98/99'\n" +
                "                      AND partidos.puntos_local > partidos.puntos_visitante\n" +
                "                    GROUP BY estadisticas.jugador\n" +
                "                    HAVING AVG((Puntos_por_partido + Asistencias_por_partido + Tapones_por_partido + Rebotes_por_partido) / 4) = (\n" +
                "                      SELECT MAX(avg_stats)\n" +
                "                        FROM (\n" +
                "                            SELECT AVG((Puntos_por_partido + Asistencias_por_partido + Tapones_por_partido + Rebotes_por_partido) / 4) AS avg_stats\n" +
                "                           FROM estadisticas\n" +
                "                         natural join partidos\n" +
                "                            WHERE partidos.equipo_local = 'Bulls'\n" +
                "                             AND partidos.equipo_visitante = 'Hornets'\n" +
                "                              AND partidos.temporada = '98/99'\n" +
                "                              AND partidos.puntos_local > partidos.puntos_visitante\n" +
                "                           GROUP BY estadisticas.jugador\n" +
                "                       ) AS subquery\n" +
                "                    )\n" +
                "                  );";
        consultas2[2]=" Select Puntos_por_partido\n" +
                "  from estadisticas\n" +
                "  where jugador=300 and temporada=\"98/99\";";
        consultas2[3]="Select Tapones_por_partido\n" +
                "  from estadisticas\n" +
                "  where jugador=300 and temporada=\"98/99\";";
        consultas2[4]=" Select Rebotes_por_partido\n" +
                "  from estadisticas\n" +
                "  where jugador=300 and temporada=\"98/99\";";
        consultas2[5]=" SELECT estadisticas.temporada\n" +
                "from jugadores inner join estadisticas natural join partidos\n" +
                "on jugadores.codigo= estadisticas.jugador\n" +
                "WHERE partidos.equipo_local = 'Bulls'\n" +
                "  AND partidos.equipo_visitante = 'Hornets'\n" +
                "  AND partidos.temporada = '98/99'\n" +
                "  AND partidos.puntos_local > partidos.puntos_visitante\n" +
                "  AND jugadores.codigo IN (\n" +
                "    SELECT estadisticas.jugador\n" +
                "     FROM estadisticas\n" +
                "         natural join partidos\n" +
                "    WHERE partidos.equipo_local = 'Bulls'\n" +
                "      AND partidos.equipo_visitante = 'Hornets'\n" +
                "      AND partidos.temporada = '98/99'\n" +
                "      AND partidos.puntos_local > partidos.puntos_visitante\n" +
                "    GROUP BY estadisticas.jugador\n" +
                "    HAVING AVG((Puntos_por_partido + Asistencias_por_partido + Tapones_por_partido + Rebotes_por_partido) / 4) = (\n" +
                "        SELECT MAX(avg_stats)\n" +
                "        FROM (\n" +
                "            SELECT AVG((Puntos_por_partido + Asistencias_por_partido + Tapones_por_partido + Rebotes_por_partido) / 4) AS avg_stats\n" +
                "           FROM estadisticas\n" +
                "         natural join partidos\n" +
                "            WHERE partidos.equipo_local = 'Bulls'\n" +
                "              AND partidos.equipo_visitante = 'Hornets'\n" +
                "              AND partidos.temporada = '98/99'\n" +
                "              AND partidos.puntos_local > partidos.puntos_visitante\n" +
                "            GROUP BY estadisticas.jugador\n" +
                "        ) AS subquery\n" +
                "    )\n" +
                "  );";
        consultas2[6]="SELECT distinct equipo_local from partidos where puntos_local>puntos_visitante and equipo_local='Hornets' and equipo_visitante='Bulls' and temporada='98/99';";
        consultas2[7]="SELECT jugadores.Nombre /*estadisticas.jugador*/\n" +
                "from jugadores inner join estadisticas natural join partidos\n" +
                "on jugadores.codigo= estadisticas.jugador\n" +
                "WHERE partidos.equipo_local = 'Hornets'\n" +
                "  AND partidos.equipo_visitante = 'Bulls'\n" +
                "  AND partidos.temporada = '98/99'\n" +
                "  AND partidos.puntos_local > partidos.puntos_visitante\n" +
                "  AND jugadores.codigo IN (\n" +
                "    SELECT estadisticas.jugador\n" +
                "     FROM estadisticas\n" +
                "         natural join partidos\n" +
                "    WHERE partidos.equipo_local = 'Hornets'\n" +
                "      AND partidos.equipo_visitante = 'Bulls'\n" +
                "      AND partidos.temporada = '98/99'\n" +
                "      AND partidos.puntos_local > partidos.puntos_visitante\n" +
                "    GROUP BY estadisticas.jugador\n" +
                "    HAVING AVG((Puntos_por_partido + Asistencias_por_partido + Tapones_por_partido + Rebotes_por_partido) / 4) = (\n" +
                "        SELECT MAX(avg_stats)\n" +
                "        FROM (\n" +
                "            SELECT AVG((Puntos_por_partido + Asistencias_por_partido + Tapones_por_partido + Rebotes_por_partido) / 4) AS avg_stats\n" +
                "           FROM estadisticas\n" +
                "         natural join partidos\n" +
                "            WHERE partidos.equipo_local = 'Hornets'\n" +
                "              AND partidos.equipo_visitante = 'Bulls'\n" +
                "              AND partidos.temporada = '98/99'\n" +
                "              AND partidos.puntos_local > partidos.puntos_visitante\n" +
                "            GROUP BY estadisticas.jugador\n" +
                "        ) AS subquery\n" +
                "    )\n" +
                "  );";
        consultas2[8]=" Select Puntos_por_partido\n" +
                "  from estadisticas\n" +
                "  where jugador=300 and temporada=\"98/99\";";
        consultas2[9]="Select Tapones_por_partido\n" +
                "  from estadisticas\n" +
                "  where jugador=300 and temporada=\"98/99\";";
        consultas2[10]=" Select Rebotes_por_partido\n" +
                "  from estadisticas\n" +
                "  where jugador=300 and temporada=\"98/99\";";
        consultas2[11]=" SELECT estadisticas.temporada\n" +
                "from jugadores inner join estadisticas natural join partidos\n" +
                "on jugadores.codigo= estadisticas.jugador\n" +
                "WHERE partidos.equipo_local = 'Hornets'\n" +
                "  AND partidos.equipo_visitante = 'Bulls'\n" +
                "  AND partidos.temporada = '98/99'\n" +
                "  AND partidos.puntos_local > partidos.puntos_visitante\n" +
                "  AND jugadores.codigo IN (\n" +
                "    SELECT estadisticas.jugador\n" +
                "     FROM estadisticas\n" +
                "         natural join partidos\n" +
                "    WHERE partidos.equipo_local = 'Hornets'\n" +
                "      AND partidos.equipo_visitante = 'Bulls'\n" +
                "      AND partidos.temporada = '98/99'\n" +
                "      AND partidos.puntos_local > partidos.puntos_visitante\n" +
                "    GROUP BY estadisticas.jugador\n" +
                "    HAVING AVG((Puntos_por_partido + Asistencias_por_partido + Tapones_por_partido + Rebotes_por_partido) / 4) = (\n" +
                "        SELECT MAX(avg_stats)\n" +
                "        FROM (\n" +
                "            SELECT AVG((Puntos_por_partido + Asistencias_por_partido + Tapones_por_partido + Rebotes_por_partido) / 4) AS avg_stats\n" +
                "           FROM estadisticas\n" +
                "         natural join partidos\n" +
                "            WHERE partidos.equipo_local = 'Hornets'\n" +
                "              AND partidos.equipo_visitante = 'Bulls'\n" +
                "              AND partidos.temporada = '98/99'\n" +
                "              AND partidos.puntos_local > partidos.puntos_visitante\n" +
                "            GROUP BY estadisticas.jugador\n" +
                "        ) AS subquery\n" +
                "    )\n" +
                "  );";
        try {
            String url = "jdbc:mysql://localhost:3306/nba";
            Connection con1 = DriverManager.getConnection(url, "root", "ivan");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement st = con1.createStatement();
            String sql = consultas2[0];
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String ganador1= rs.getString("equipo_local");


                SalidaGanadorAnterior2_1.setText(ganador1);

            }
            con1.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            String url = "jdbc:mysql://localhost:3306/nba";
            Connection con1 = DriverManager.getConnection(url, "root", "ivan");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement st = con1.createStatement();
            String sql = consultas2[1];
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String MejorJugador1= rs.getString("jugadores.Nombre");


                SalidaJugadorAnterior2_1.setText(MejorJugador1);

            }
            con1.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            String url = "jdbc:mysql://localhost:3306/nba";
            Connection con1 = DriverManager.getConnection(url, "root", "ivan");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement st = con1.createStatement();
            String sql = consultas2[2];
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String puntos1= rs.getString("Puntos_por_partido");


                SalidaPuntosAnterior2_1.setText(puntos1);

            }
            con1.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            String url = "jdbc:mysql://localhost:3306/nba";
            Connection con1 = DriverManager.getConnection(url, "root", "ivan");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement st = con1.createStatement();
            String sql = consultas2[3];
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String tapones1= rs.getString("Tapones_por_partido");


                SalidaTaponesAnterior2_1.setText(tapones1);

            }
            con1.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            String url = "jdbc:mysql://localhost:3306/nba";
            Connection con1 = DriverManager.getConnection(url, "root", "ivan");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement st = con1.createStatement();
            String sql = consultas2[4];
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String rebotes1= rs.getString("Rebotes_por_partido");


                SalidaRebotesAnterior2_1.setText(rebotes1);

            }
            con1.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            String url = "jdbc:mysql://localhost:3306/nba";
            Connection con1 = DriverManager.getConnection(url, "root", "ivan");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement st = con1.createStatement();
            String sql = consultas2[5];
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String temporada1= rs.getString("estadisticas.temporada");


                SalidTemporadaAnterior2_11.setText(temporada1);

            }
            con1.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            String url = "jdbc:mysql://localhost:3306/nba";
            Connection con1 = DriverManager.getConnection(url, "root", "ivan");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement st = con1.createStatement();
            String sql = consultas2[6];
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String ganador2= rs.getString("equipo_local");


                SalidaGanadorAnterior2_2.setText(ganador2);

            }
            con1.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            String url = "jdbc:mysql://localhost:3306/nba";
            Connection con1 = DriverManager.getConnection(url, "root", "ivan");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement st = con1.createStatement();
            String sql = consultas2[7];
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String MejorJugador2= rs.getString("jugadores.Nombre");


                SalidaJugadorAnterior2_2.setText(MejorJugador2);

            }
            con1.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            String url = "jdbc:mysql://localhost:3306/nba";
            Connection con1 = DriverManager.getConnection(url, "root", "ivan");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement st = con1.createStatement();
            String sql = consultas2[8];
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String puntos2= rs.getString("Puntos_por_partido");


                SalidaPuntosAnterior2_2.setText(puntos2);

            }
            con1.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            String url = "jdbc:mysql://localhost:3306/nba";
            Connection con1 = DriverManager.getConnection(url, "root", "ivan");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement st = con1.createStatement();
            String sql = consultas2[9];
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String tapones2= rs.getString("Tapones_por_partido");


                SalidaTaponesAnterior2_2.setText(tapones2);

            }
            con1.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            String url = "jdbc:mysql://localhost:3306/nba";
            Connection con1 = DriverManager.getConnection(url, "root", "ivan");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement st = con1.createStatement();
            String sql = consultas2[10];
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String rebotes2= rs.getString("Rebotes_por_partido");


                SalidaRebotesAnterior2_2.setText(rebotes2);

            }
            con1.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            String url = "jdbc:mysql://localhost:3306/nba";
            Connection con1 = DriverManager.getConnection(url, "root", "ivan");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement st = con1.createStatement();
            String sql = consultas2[11];
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String temporada2= rs.getString("estadisticas.temporada");


                SalidTemporadaAnterior2_2.setText(temporada2);

            }
            con1.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }




    }

    @FXML
    void PulsarBotonVerEstadisticas(ActionEvent event) {
        String[] consultas= new String[5];
        consultas[0]="SELECT distinct equipo_local from partidos where puntos_local>puntos_visitante and equipo_local='Bulls' and equipo_visitante='Hornets' and temporada='00/01';";
        consultas[1]="SELECT jugadores.Nombre /*estadisticas.jugador*/\n" +
                "from jugadores inner join estadisticas natural join partidos\n" +
                "on jugadores.codigo= estadisticas.jugador\n" +
                "WHERE partidos.equipo_local = 'Bulls'\n" +
                "  AND partidos.equipo_visitante = 'Hornets'\n" +
                "  AND partidos.temporada = '00/01'\n" +
                "  AND partidos.puntos_local > partidos.puntos_visitante\n" +
                "  AND jugadores.codigo IN (\n" +
                "    SELECT estadisticas.jugador\n" +
                "     FROM estadisticas\n" +
                "         natural join partidos\n" +
                "    WHERE partidos.equipo_local = 'Bulls'\n" +
                "      AND partidos.equipo_visitante = 'Hornets'\n" +
                "      AND partidos.temporada = '00/01'\n" +
                "      AND partidos.puntos_local > partidos.puntos_visitante\n" +
                "    GROUP BY estadisticas.jugador\n" +
                "    HAVING AVG((Puntos_por_partido + Asistencias_por_partido + Tapones_por_partido + Rebotes_por_partido) / 4) = (\n" +
                "        SELECT MAX(avg_stats)\n" +
                "        FROM (\n" +
                "            SELECT AVG((Puntos_por_partido + Asistencias_por_partido + Tapones_por_partido + Rebotes_por_partido) / 4) AS avg_stats\n" +
                "           FROM estadisticas\n" +
                "         natural join partidos\n" +
                "            WHERE partidos.equipo_local = 'Bulls'\n" +
                "              AND partidos.equipo_visitante = 'Hornets'\n" +
                "              AND partidos.temporada = '00/01'\n" +
                "              AND partidos.puntos_local > partidos.puntos_visitante\n" +
                "            GROUP BY estadisticas.jugador\n" +
                "        ) AS subquery\n" +
                "    )\n" +
                "  );";
        consultas[2]=" Select Puntos_por_partido\n" +
                "  from estadisticas\n" +
                "  where jugador=300 and temporada=\"00/01\";";
        consultas[3]="Select Tapones_por_partido\n" +
                "  from estadisticas\n" +
                "  where jugador=300 and temporada=\"00/01\";";
        consultas[4]=" Select Rebotes_por_partido\n" +
                "  from estadisticas\n" +
                "  where jugador=300 and temporada=\"00/01\";";


        try {
            String url = "jdbc:mysql://localhost:3306/nba";
            Connection con1 = DriverManager.getConnection(url, "root", "ivan");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement st = con1.createStatement();
            String sql = consultas[0];
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String ganador= rs.getString("equipo_local");


                SalidaGanadorAnterior.setText(ganador);

            }
            con1.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            String url = "jdbc:mysql://localhost:3306/nba";
            Connection con1 = DriverManager.getConnection(url, "root", "ivan");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement st = con1.createStatement();
            String sql = consultas[1];
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String MejorJugador= rs.getString("jugadores.Nombre");


                SalidaJugadorAnterior.setText(MejorJugador);

            }
            con1.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            String url = "jdbc:mysql://localhost:3306/nba";
            Connection con1 = DriverManager.getConnection(url, "root", "ivan");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement st = con1.createStatement();
            String sql = consultas[2];
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String puntos= rs.getString("Puntos_por_partido");


                SalidaPuntosAnterior.setText(puntos);

            }
            con1.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            String url = "jdbc:mysql://localhost:3306/nba";
            Connection con1 = DriverManager.getConnection(url, "root", "ivan");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement st = con1.createStatement();
            String sql = consultas[3];
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String tapones= rs.getString("Tapones_por_partido");


                SalidaTaponesAnterior.setText(tapones);

            }
            con1.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            String url = "jdbc:mysql://localhost:3306/nba";
            Connection con1 = DriverManager.getConnection(url, "root", "ivan");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement st = con1.createStatement();
            String sql = consultas[4];
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String rebotes= rs.getString("Rebotes_por_partido");


                SalidaRebotesAnterior.setText(rebotes);

            }
            con1.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }




        }
    @FXML
    void PulsarBotonVolverAnteriores(ActionEvent event) {
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("PartidoAnterior.fxml"));
        try{
            Parent root =fxmlLoader.load();
            Scene scene= new Scene(root);
            Stage stage= new Stage();

            stage.setScene(scene);
            stage.show();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    }


