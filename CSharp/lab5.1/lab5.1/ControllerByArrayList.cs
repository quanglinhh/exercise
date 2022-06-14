using System;
using System.Collections;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab5._1
{
    internal class ControllerByArrayList
    {
       ArrayList products = new ArrayList();
        //Add data to collection
        public void AddCollection()
        {
            string query = $"SELECT * FROM product";
            //Connect to database
            DbConnection connectionDB = new DbConnection();
            SqlConnection connection = connectionDB.GetConnection();
            //
            SqlCommand command = new SqlCommand(query, connection);
            connection.Open();
            SqlDataReader reader = command.ExecuteReader();
            while (reader.Read())
            {
                Product productValue = new Product(Convert.ToInt32(reader[0]), Convert.ToString(reader[1]), Convert.ToString(reader[2]), Convert.ToDouble(reader[3]));
                products.Add(productValue);
            }
            connection.Close();
        }
        //Update data to SQL
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
        public static int GetId(string name, double price, string desc)
        {
            int id = 0;
            string query = $"SELECT id FROM product WHERE proName = '{name}'AND price = {price} AND proDesc = '{desc}'";
            //Connect to database
            DbConnection connectionDB = new DbConnection();
            SqlConnection connection = connectionDB.GetConnection();
            //
            SqlCommand command = new SqlCommand(query, connection);
            connection.Open();
            SqlDataReader reader = command.ExecuteReader();
            while (reader.Read())
            {
                id = Convert.ToInt32(reader[0]);
            }
            connection.Close();
            return id;
        }
        public bool CheckConstrain(string data, string type)
        {
            if (type == "id")
            {
                int id = Convert.ToInt32(data);
                foreach (Product product in products)
                {
                    if (product.Id == id)
                    {
                        return true;
                    }
                }
            }
            else if (type == "name")
            {
                foreach (Product product in products)
                {
                    if (string.Equals(data, product.Name))
                    {
                        return true;
                    }
                }
            }
            return false;
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
            string name = Console.ReadLine().ToLower();
            Console.Write("Input Desc of product: ");
            string desc = Console.ReadLine().ToLower();
            Console.Write("Input price of product: ");
            double price = Convert.ToDouble(Console.ReadLine());
            //Connect to database
            DbConnection connectionDB = new DbConnection();
            SqlConnection connection = connectionDB.GetConnection();
            //
            string query = $"INSERT INTO product VALUES('{name}','{desc}',{price})";
            Update(query);
            Console.ForegroundColor = ConsoleColor.Green;
            Console.WriteLine("Add produc succesfull!");
            Console.ResetColor();
            //Add to Colection           
            int id = GetId(name, price,desc);
            Product product = new Product(id,name, desc, price);
            products.Add(product);
        }
        //Edit product
        public void EditProduct()
        {

            Console.Write("Enter the id of product you wan edit: ");
            int id = int.Parse(Console.ReadLine());            
            if (CheckConstrain(Convert.ToString(id), "id"))
            {       
                foreach(Product product in products)
                {
                    if(product.Id == id)
                    {
                        Console.ForegroundColor = ConsoleColor.Cyan;
                        Console.WriteLine($"Edit product: {product}");
                        Console.ResetColor();
                        try
                        {
                            int choice = 0;
                            while (choice != 4)
                            {
                                EditMenu();
                                choice = int.Parse(Console.ReadLine());
                                string query;

                                switch (choice)
                                {
                                    case 1:
                                        Console.Write("Enter new name of product: ");
                                        string newName = Console.ReadLine();                                     
                                        product.Name = newName;
                                        break;
                                    case 2:
                                        Console.Write("Enter new Desc of product: ");
                                        string newDesc = Console.ReadLine();                                       
                                        product.Description = newDesc;
                                        break;
                                    case 3:
                                        Console.Write("Enter new price of product: ");
                                        double newPrice = double.Parse(Console.ReadLine());
                                        product.Price = newPrice;
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
                                string query = $"UPDATE product SET proName = '{product.Name}', price = {product.Price}, proDesc = '{product.Description}' WHERE id = {id}";
                                Update(query);
                                Console.ForegroundColor = ConsoleColor.Green;
                                Console.WriteLine("Update product with id = {0} succesful!", id);
                                Console.ResetColor();
                                Program.RunProgram();
                            }
                        }
                        catch (FormatException)
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
            if (CheckConstrain(Convert.ToString(id), "id"))
            {
                foreach (Product product in products)
                {
                    products.Remove(id);
                    string query = $"DELETE FROM product WHERE id = {id}";
                    Update(query);
                    Console.ForegroundColor = ConsoleColor.Green;
                    Console.WriteLine("Deleted product with id = {0}", id);
                    Console.ResetColor();
                }
            }
            else
            {
                Console.ForegroundColor = ConsoleColor.Yellow;
                Console.WriteLine("Product not found!");
                Console.ResetColor();
                DeleteProduct();
            }
        }
        //View all product
        public void ViewAllProducts()
        {           
            foreach (Product product in products)
            {
                Console.ForegroundColor = ConsoleColor.Green;
                Console.WriteLine(product);
                Console.ResetColor();
            }
            
        }
        //Search Product
        public void SearchProductById()
        {
            Console.Write("Enter the id of product: ");
            int id = int.Parse(Console.ReadLine());
            
            if (CheckConstrain(Convert.ToString(id), "id"))
            {
                foreach(Product product in products)
                {
                    if(product.Id == id)
                    {
                        Console.ForegroundColor = ConsoleColor.Green;
                        Console.WriteLine(product);
                        Console.ResetColor();
                    }
                }              
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
            string name = Console.ReadLine().ToLower();
           
            if (CheckConstrain(name,"name"))
            {
                foreach(Product product in products)
                {
                    if (string.Equals(product.Name, name))
                    {
                        Console.ForegroundColor = ConsoleColor.Green;
                        Console.WriteLine(product);
                        Console.ResetColor();
                    }
                }                
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
