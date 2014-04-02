package DataSource;

import java.sql.Connection;
import domain.*;
/**
 *
 * @author Anders Kjær
 */
// Encapsulates the Data Source Layer
// Encapsulates connection handling 
// Implemented as a Singleton to provide global access from
// Domain classes and to ensure the use of max one connection

public class DBFacade {

	  private ReservationMapper rm; 
	  private Connection con;
	  
	  //== Singleton start
	  private static DBFacade instance;
	 
	  private DBFacade() {
		  rm 	= new ReservationMapper(); // http://dadicy.wordpress.com/2007/10/29/what-do-you-mean-by-static-in-java/
		  con 	= new DBConnector().getConnection();  // the connection will be released upon program 
		  					     // termination by the garbage collector		  
	  }
	  public static DBFacade getInstance()
	  {
		  if(instance == null)   //er instance = null , så laver den en ny instance af DBFacade
			  instance = new DBFacade();
		  return instance;  // den kan altså ikke lave flere instanser af DBFacade end der allerede er
	  }
	  //== Singleton end!

	  
	  public Reservation getReservation(int reservationID) 
	  {
		  return rm.getReservation(reservationID, con);	   // rm. er ReservationMapper, con. er new connection 
	  }
	  
	  public boolean saveNewReservation(Reservation o)
	  { 
	    return rm.saveNewReservation(o, con); // rm. er ReservationMapper 
	  }
	  
	  public boolean saveNewReservationDetail(reservationDetail od)
	  {
	    return rm.saveNewReservationDetail(od, con);  // rm. er ReservationMapper
	  }
	
}