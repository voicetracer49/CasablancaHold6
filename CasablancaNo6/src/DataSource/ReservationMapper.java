
package DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Anders, Ruben
 */
import Domain.Reservation;
import Domain.ReservationDetail;

public class ReservationMapper
{
//=== Maps between objects and tables
//=== Encapsulates SQL-statements

    public Reservation getReservation(int reservarionID, Connection con)
    {
        Reservation o = null;
        String SQLString1 = // get order
                "select * from tblReservation where reservationID = ?";
        String SQLString2 = // get order details
                "select od.pno, od.qty from tbl od where od.reservationID = ? "; // foreign key match 
        PreparedStatement statement = null;

        try
        {
            //=== get order
            statement = con.prepareStatement(SQLString1);
            statement.setInt(1, reservationID);     // primary key value
            ResultSet rs = statement.executeQuery();
            if (rs.next())
            {
                o = new Reservation(reservationID,
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5));
            }

            //=== get order details
            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, reservationID);          // foreign key value
            rs = statement.executeQuery();
            while (rs.next())
            {
                o.addDetail(new reservationDetail(reservationID,rs.getInt(1),rs.getInt(2)));
            }
        } catch (Exception e)
        {
            System.out.println("Fail in ReservationMapper - getReservation");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in ReservationMapper - getReservation");
                System.out.println(e.getMessage());
            }
        }
        return o;
    }

    //== Insert new order (tuple)
    public boolean saveNewOrder(Reservation o, Connection con)
    {
        int rowsInserted = 0;
        String SQLString1 =
                "select reservationseq.nextval from dual";
        String SQLString2 =
                "insert into tblReservation values (?,?,?,?,?)";
        PreparedStatement statement = null;

        try
        {
            //== get unique ono
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery();
            if (rs.next())
            {
                o.setOno(rs.getInt(1));
            }

            //== insert tuple
            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, o.getOno());
            statement.setInt(2, o.getCustomerNo());
            statement.setInt(3, o.getEmployeeNo());
            statement.setString(4, o.getReceived());
            statement.setString(5, o.getShipped());
            rowsInserted = statement.executeUpdate();
        } catch (Exception e)
        {
            System.out.println("Fail in OrderMapper - saveNewOrder");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in OrderMapper - saveNewOrder");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }

    //== Insert new order detail (tuple)
    public boolean saveNewOrderDetail(OrderDetail od, Connection con)
    {
        int rowsInserted = 0;
        String SQLString =
                "insert into odetails "
                + "values (?,?,?)";
        PreparedStatement statement = null;

        try
        {
            //== insert tuple
            statement = con.prepareStatement(SQLString);
            statement.setInt(1, od.getOno());
            statement.setInt(2, od.getPno());
            statement.setInt(3, od.getQty());
            rowsInserted = statement.executeUpdate();
        } catch (Exception e)
        {
            System.out.println("Fail in OrderMapper - saveNewOrderDetail");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in OrderMapper - saveNewOrderDetail");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }
}

