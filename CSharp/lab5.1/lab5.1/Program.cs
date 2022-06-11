using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;
using System.Data;

namespace lab5._1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string connectionString =
                "Data source = localhost; Initial Catalog= myjdbcapp;User = sa; password=as";
            SqlConnection connection = new SqlConnection(connectionString);
            string query = "SELECT * FROM employee";
            SqlCommand sqlCommand = new SqlCommand(query,connection);
            connection.Open();
            SqlDataReader reader = sqlCommand.ExecuteReader();
            while (reader.Read())
            {
                Console.WriteLine("empno: " + reader[1]+"name: " + reader[2]);
            }
            Console.ReadLine();
        }
    }
}
