
package com.mycompany.zcondo;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarView;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AgendaController implements Initializable {
 
    @Override
    public void initialize (URL url,ResourceBundle rb) {{
           
       Scene scene; 

        CalendarView calendarView = new CalendarView();

        Calendar espacoPiscina = new Calendar("Piscina");
        Calendar espacoSalaoDeFestas = new Calendar("Salão de Festas");
        
        Entry<String> eventos = new Entry<>("Dentista");
        espacoPiscina.addEntry(eventos);                            /////////// Adicionando eventos para o mesmo dia 

        espacoPiscina.setStyle(Calendar.Style.STYLE6);
        espacoSalaoDeFestas.setStyle(Calendar.Style.STYLE2);

        CalendarSource myCalendarSource = new CalendarSource("My Calendars");
        myCalendarSource.getCalendars().addAll(espacoPiscina, espacoSalaoDeFestas);

        calendarView.getCalendarSources().addAll(myCalendarSource);

        calendarView.setRequestedTime(LocalTime.now());

        Thread updateTimeThread = new Thread("Calendar: Update Time Thread") {
            
            @Override
            public void run() {
                while (true) {
                    Platform.runLater(() -> {
                        calendarView.setToday(LocalDate.now());    //Configura data e hora
                        calendarView.setTime(LocalTime.now());
                    });

                    try {
                        // update every 10 seconds
                        sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        updateTimeThread.setPriority(Thread.MIN_PRIORITY);
        updateTimeThread.setDaemon(true);
        updateTimeThread.start();
 
        scene = new Scene(calendarView);
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        stage.setTitle("Condomínio");
        stage.setScene(scene);
        stage.setWidth(700);    
        stage.setHeight(500);
        stage.centerOnScreen();
        stage.show();
    }
    
    
    
}}
