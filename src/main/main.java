package main;

import java.sql.*;

import DAO.*;

public class main {
    public static void main(String[] args) throws SQLException 
    {
        PrevisionDao p = new PrevisionDao();
        DepenseDao dp = new DepenseDao();
        System.out.println(p.getReste(1,2));
        System.out.println(dp.getSumDepense(1,2));
    }
}