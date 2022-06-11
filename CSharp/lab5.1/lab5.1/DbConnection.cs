using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab5._1
{
    internal class DbConnection
    {
        public SqlConnection GetConnection()
        {
            string connectionString =
                "Data source = localhost; Initial Catalog= myjdbcapp;User = sa; password=as";
            SqlConnection connection = new SqlConnection(connectionString);
            return connection;
        } 
    }
}
