
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
        Reservation res = null;
        String SQLString1 = // get order
                "select * from G6_Reservation where reservationID = ?";
        String SQLString2 = // get order details
                "select resd.pno, resd.qty from tbl od where od.reservationID = ? "; // foreign key match 
        PreparedStatement statement = null;

        try
        {
            //=== get order
            statement = con.prepareStatement(SQLString1);
            statement.setInt(1, reservationID);     // primary key value
            ResultSet rs = statement.executeQuery();
            if (rs.next())
            {
                res = new Reservation(reservationID,
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5));
            }

            //=== get order details
            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, reservationID);          // foreign key value
            rs = statement.executeQuery();
            while (rs.next())   //?
            {
                res.addDetail(new reservationDetail(reservationID,rs.getInt(1),rs.getInt(2)));
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
        return res;
    }

    //== Insert new order (tuple)
    public boolean saveNewReservation(Reservation res, Connection con)
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
                res.setOno(rs.getInt(1));
            }

            //== insert tuple
            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, res.getOno());
            statement.setInt(2, res.getCustomerNo());
            statement.setInt(3, res.getEmployeeNo());
            statement.setString(4, res.getReceived());
            statement.setString(5, res.getShipped());
            rowsInserted = statement.executeUpdate();
        } catch (Exception e)
        {
            System.out.println("Fail in OrderMapper - saveNewReservation");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fail in OrderMapper - saveNewreservation");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }

    //== Insert new order detail (tuple)
    public boolean saveNewReservationDetail(reservationDetail resd, Connection con)
    {
        int rowsInserted = 0;
        String SQLString =
                "insert into odetails "  //?
                + "values (?,?,?)";
        PreparedStatement statement = null;

        try
        {
            //== insert tuple
            statement = con.prepareStatement(SQLString);
            statement.setInt(1, resd.getOno());
            statement.setInt(2, resd.getPno());
            statement.setInt(3, resd.getQty());
            rowsInserted = statement.executeUpdate();
        } catch (Exception e)
        {
            System.out.println("Fail in OrderMapper - saveNewReservationDetail");
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

