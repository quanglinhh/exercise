using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab7
{
    internal class DbConnection
    {
        public SqlConnection GetConnection()
        {
            string connectionString =
                "Data source = localhost; Initial Catalog= employeeApp;User = sa; password=as";
            SqlConnection connection = new SqlConnection(connectionString);
            return connection;
        }
    }
}
