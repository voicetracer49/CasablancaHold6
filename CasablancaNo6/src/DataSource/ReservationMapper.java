
package DataSource;

import Domain.Reservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ReservationMapper
{
//=== Maps between objects and tables
//=== Encapsulates SQL-statements

private int reservationID;
private final Connection con;

    public ReservationMapper(Connection con) {
        this.con = con;
    }


    //== Insert new order (tuple)
    public Reservation getReservation(int reservationID, Connection con)
    {
        Reservation r = null;
       String SQLString1 = // get order
                "select * "
                + "from G6_Reservation "
                + "where reservationId = ?";
    
        PreparedStatement statement = null;

       try{
       statement = con.prepareStatement(SQLString1);
            statement.setInt(1, reservationID);     // primary key value  // kunne evt. laves om til :: Where lName starts with ?
            ResultSet rs = statement.executeQuery();
            if (rs.next())
                {//=== get Reservation details
                r = new Reservation(reservationID,  //1  int reservationId
                        rs.getInt(2),               //2  int roomID;
                        rs.getString(3),              //3 DATE checkIn
                        rs.getString(4),             //4 DATE checkOut
                        rs.getBoolean(5));           //5 boolean confirmed
                        }
       }catch(Exception e){
            System.out.println("Fail");
            System.out.println(e.getMessage());
       }finally
            {
                    try{
                    statement.close();
                    }catch (SQLException e) {
                System.out.println("Fail");
                System.out.println(e.getMessage());
            }
        }
        return r;
                    
       }
        //== Insert new order (tuple)
    public boolean saveNewReservation(Reservation r, Connection con)
    {
        int rowsInserted = 0;
        String SQLString1 =
                "select G6_RES_SEQ.NEXTVAL from DUAL";
//        INSERT INTO suppliers
//        (supplier_id, supplier_name)
//        VALUES
//        (G6_res_seq.NEXTVAL, 'Kraft Foods');
//    ---old    select reservationseq.nextval from dual
        
        String SQLString2 =
                "insert into G6_Reservation values (?,?,?,?,?)";
        PreparedStatement statement = null;

        try
        {
            //== get unique ono
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery();
            if (rs.next())
            {
                r.setReservationID(rs.getInt(1));
            }

            //== insert tuple
            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, r.getReservationID());
            statement.setInt(2, r.getRoomID());
            statement.setString(3, r.getCheckIn());
            statement.setString(4, r.getCheckOut());
            statement.setBoolean(5, r.isConfirmed());
        } catch (Exception e)
        {
            System.out.println("Fail");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail");
                System.out.println(e.getMessage());
            }
        }
        
        System.out.println("false reservertion" + rowsInserted);
        return rowsInserted == 1;
        
    }
}           
   