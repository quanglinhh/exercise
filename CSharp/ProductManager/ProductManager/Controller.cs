using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProductManager
{
    internal class Controller
    {
       
        ArrayList products = new ArrayList();
        public void AddProduct()
        {
            Console.Write("Enter the product Id: ");
            string id = Console.ReadLine();
            if (CheckConstraint(id)){
                Console.ForegroundColor = ConsoleColor.Yellow;
                Console.WriteLine("Product constraint!, enter another id");
                Console.ResetColor();
                AddProduct();
            }
            else
            {
                Console.Write("Enter the product name: ");
                string name = Console.ReadLine();
                Console.Write("Enter the price of product: ");
                double price = double.Parse(Console.ReadLine());
                Product product = new Product(id, name, price);
                products.Add(product);
                Console.ForegroundColor = ConsoleColor.Green;
                Console.WriteLine("Add product successful!");
                Console.ResetColor ();
            }       
        }
        public void DisplayProduct()

        {
            Console.ForegroundColor = ConsoleColor.Green;
            foreach (Product product in products)
            {
                Console.WriteLine(product);
            }
            Console.ResetColor ();
        }
        public void DeleteProductById()
        {
            Console.Write("Enter the produc Id: ");
            string id = Console.ReadLine();
            if (CheckConstraint(id))
            {

                    
                foreach (Product product in products)
                {
                    if(string.Equals(product.ProductId,id))
                    {
                        products.Remove(product);
                        Console.ForegroundColor = ConsoleColor.Green;
                        Console.WriteLine("Delete product successful!");
                        Console.ResetColor();
                    }
                }
            }
            else
            {
                Console.ForegroundColor = ConsoleColor.Yellow;
                Console.WriteLine("Product not constraint!");
                Console.ResetColor();
            }
        }
        public bool CheckConstraint(string id)
        {
            foreach(Product product in products)
            {
                if(product.ProductId == id)
                {
                    return true;
                }
            }
            return false;
        }
    }
}
