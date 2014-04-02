package Domain;
/*
 * @author https://github.com/voicetracer49/CphBussiness-2semOpgave.git
 * Anders, Marcus, Ruben - Before you Start ->
 * http://www.git-tower.com/learn/version-control-best-practices.html
 */

import Datasource.*;
import oracle.sql.DATE;
public class Controller
{

    private Reservation currentReservation;   // order in focus
    private DBFacade dbf;  //ref.Variabel til instans af DBFacade
    
    public Controller()
    {
        currentReservation = null;
        dbf = DBFacade.getInstance();  // afhængig af navngivning i DBFacade?   
    }
    public Reservation createNewReservation(int roomNummerID,int roomTypeID, DATE reservationFrom,DATE reservationTo, char reservationConfirmed, DATE reservationCreated,DATE reservationModifyed, char reservationDeleted) // skal sættes fra reservationDetailClassen ! 
     // int reservationId hentes og den medsendes i NewReservation her ovenfor??   __ Længden på tabellernes atributter bør forkortes!  Date datatype ukendt !
    {
        //== create order object with ReservationID=0
        currentReservation = new Reservation(0 ,roomNummerID ,roomTypeID ,reservationFrom ,reservationTo ,reservationConfirmed ,reservationCreated ,reservationModifyed ,reservationDeleted);
                //== save and get DB-generated unique reservationID
    boolean status = dbf.saveNewReservation(currentReservation);
        if (!status) //fail!
        {
            currentReservation = null;
        }

        return currentReservation;
    }
    
     String list;
     public availableRooms getAvailableRooms(int ){   // select * frpm 
     
     
     return list;
     }   
    
     public Reservation getReservation(Number reservationID)
    {
        currentReservation = dbf.getReservation(reservationID);
        return currentReservation;
    }
    
    
    
}

