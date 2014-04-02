/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;
import oracle.sql.DATE;

/**
 * @author Anders Kjær, Ruben juul
 */
public class ReservationDetail
{

    ArrayList<GuestDetail> gd;
    String roomType;
    boolean deposit;
    DATE date;    // sørgsmål om der ikke her skal benyttes Java Datatyper

    public ReservationDetail(ArrayList<GuestDetail> gd, String roomType, boolean deposit, DATE date) // Skal der ikke stå <reservationDetail> her ?
    {
        this.gd = gd;
        this.roomType = roomType;
        this.deposit = deposit;
        this.date = date;
    }
    
    
    //--------- --- orderdetail KOPI fra DataSourceLayer Herunder 
        private int ono; // ono and pno are FK's but at the same time a constitute the PK!  
        private int pno; // Therefore they are kept in the object (Identity Map)
        private int qty;

        public ReservationDetail(int on, int pn, int q)
        {
            ono = on;
            pno = pn;
            qty = q;
        }

        //=== accessors
        public int getOno()
        {
            return ono;
        }

        public int getPno()
        {
            return pno;
        }

        public int getQty()
        {
            return qty;
        }

        public String toString()
        {
            return ono + " " + pno + " " + qty;
        }
}

