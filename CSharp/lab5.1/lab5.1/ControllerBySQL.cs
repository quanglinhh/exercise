using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab5._1
{
    internal class ControllerBySQL
    {    
        //Check contain
        public bool CheckProductContain(string data)
        {

            DbConnection connectionDB = new DbConnection();
            SqlConnection connection = connectionDB.GetConnection();
            //
            string query = $"SELECT CAST(COUNT(1) AS BIT) AS Expr1 FROM[product] WHERE({data})";
            SqlCommand cmd = new SqlCommand(query, connection);
            connection.Open();
            SqlDataReader reader = cmd.ExecuteReader();
            string result = "";
            while (reader.Read())
            {
                //Console.WriteLine(reader[0]);
                result = Convert.ToString(reader[0]);

            }
            connection.Close();
            if (result == "True")
            {
                return true;
            }
            else
            {
                return false;
            }



        }
        //Execute Update
        public static void Update(string query)
        {
            //Connect to database
            DbConnection connectionDB = new DbConnection();
            SqlConnection connection = connectionDB.GetConnection();
            //
            SqlCommand command = new SqlCommand(query, connection);
            connection.Open();

            // Thực thi Command (Dùng cho delete, insert, update).
            command.ExecuteNonQuery();
            connection.Close();


        }
        //Execute Query
        public void Display(string query)
        {
            //Connect to database
            DbConnection connectionDB = new DbConnection();
            SqlConnection connection = connectionDB.GetConnection();
            //
            SqlCommand command = new SqlCommand(query, connection);
            connection.Open();


            SqlDataReader reader = command.ExecuteReader();

            while (reader.Read())
            {
                
                Console.ForegroundColor = ConsoleColor.Green;
                Console.WriteLine("Product name: " + reader[1] + "   |  Product Desc: " + reader[2] + "   |   Price: " + reader[3]);
                Console.WriteLine("------------------------------------------------------------");
                Console.ResetColor();

            }
        }
        public static void EditMenu()
        {
            Console.WriteLine("======You want edit? ======");
            Console.WriteLine("1. Name of product");
            Console.WriteLine("2. Desc of product");
            Console.WriteLine("3. Price of product");
            Console.WriteLine("4. finish");
        }

        /*=======================================PROGRAM======================================*/
        //Add product
        public void AddProduct()
        {
            Console.Write("Input name of product: ");
            string name = Console.ReadLine();
            Console.Write("Input Desc of product: ");
            string desc = Console.ReadLine();
            Console.Write("Input price of product: ");
            double price = Convert.ToDouble(Console.ReadLine());
            //Connect to database
            DbConnection connectionDB = new DbConnection();
            SqlConnection connection = connectionDB.GetConnection();
            //
            string query = $"INSERT INTO product VALUES('{name}','{desc}',{price})";
            SqlCommand cmd = new SqlCommand(query, connection);
            connection.Open();
            cmd.ExecuteNonQuery();
            connection.Close();
            Console.ForegroundColor = ConsoleColor.Green;
            Console.WriteLine("Add produc succesfull!");
            Console.ResetColor();
        }
        //Edit product
        public void EditProduct()
        {
            Console.Write("Enter the id of product you wan edit: ");
            int id = int.Parse(Console.ReadLine());
            string data = $"id = {id}";
            CheckProductContain(data);
            if (CheckProductContain(data))
            {
                Console.ForegroundColor = ConsoleColor.Cyan;
                Console.Write("Edit product: ");
                string query = $"SELECT * FROM product WHERE id = {id}";
                Display(query);
                Console.ResetColor();
                try
                {
                    int choice = 0;
                    while (choice != 4)
                    {
                        EditMenu();
                        choice = int.Parse(Console.ReadLine());                       
                        switch (choice)
                        {
                            case 1:
                                Console.Write("Enter new name of product: ");
                                string newName = Console.ReadLine();
                                query = $"UPDATE product SET proName = '{newName}' WHERE id = '{id}'";
                                Update(query);
                                break;
                            case 2:
                                Console.Write("Enter new Desc of product: ");
                                string newDesc = Console.ReadLine();
                                query = $"UPDATE product SET proDesc = '{newDesc}' WHERE id = '{id}'";
                                Update(query);
                                break;
                            case 3:
                                Console.Write("Enter new price of product: ");
                                string newPrice = Console.ReadLine();
                                query = $"UPDATE product SET price = '{newPrice}' WHERE id = '{id}'";
                                Update(query);
                                break;
                            case 4:
                                break;
                            default:
                                Console.ForegroundColor = ConsoleColor.Red;
                                Console.WriteLine("wrong syntax, please choice again!");
                                Console.ResetColor();
                                break;
                        }

                    }
                    if (choice == 4)
                    {
                        Console.ForegroundColor = ConsoleColor.Green;
                        Console.WriteLine("Update product with id = {0} succesful!", id);
                        Console.ResetColor();
                        Program.RunProgram();
                    }
                }
                catch (FormatException ex)
                {
                    Console.ForegroundColor = ConsoleColor.Red;
                    Console.WriteLine("wrong syntax, please choice again!");
                    Console.ResetColor();
                }
                finally
                {

                    EditProduct();
                }
            }
            else
            {
                Console.ForegroundColor = ConsoleColor.Yellow;
                Console.WriteLine("Product not found!");
                Console.ResetColor();
                EditProduct();
            }
        } 
        //Delete product
        public void DeleteProduct()
        {
            Console.Write("Enter the id of product you wan delete: ");
            int id = int.Parse(Console.ReadLine());

            string data = $"id = {id}";
            CheckProductContain(data);

            if (CheckProductContain(data))
            {
                string query = $"DELETE FROM product WHERE id = {id}";
                Update(query);
                Console.ForegroundColor = ConsoleColor.Green;
                Console.WriteLine("Deleted product with id = {0}", id);
                Console.ResetColor();             
            }
            else
            {
                Console.ForegroundColor = ConsoleColor.Yellow;
                Console.WriteLine("Product not found!");
                Console.ResetColor();
                DeleteProduct();
            }
        }
        //View All product
        public void ViewAllProducts()
        {
            string query = $"SELECT * FROM product";
            Display(query);
        }
        //Search product
        public void SearchProductById()
        {
            Console.Write("Enter the id of product: ");
            int id = int.Parse(Console.ReadLine());
            string data = $"id = {id}";
            CheckProductContain(data);

            if (CheckProductContain(data))
            {
                string query = $"SELECT * FROM product WHERE id = {id}";
                Display(query);
            }
            else
            {
                Console.ForegroundColor = ConsoleColor.Yellow;
                Console.WriteLine("Product not found!");
                Console.ResetColor();
            }
        }
        public void SearchProductByName()
        {
            Console.Write("Enter the name of product : ");
            string name = Console.ReadLine();
            string data = $" proName = '{name}'";
            CheckProductContain(data);
            if (CheckProductContain(data))
            {
                string query = $"SELECT * FROM product WHERE proName = '{name}'";
                Display(query);

            }
            else
            {
                Console.ForegroundColor = ConsoleColor.Yellow;
                Console.WriteLine("Product not found!");
                Console.ResetColor();

            }
        }    
    }
}
