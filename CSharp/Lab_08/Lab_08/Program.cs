using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Part1_1
{
    class Product
    {
        private string name;
        private double cost;
        private int onhand;

        public Product(string n, double c, int h)
        {
            this.name = n;
            this.cost = c;
            this.onhand = h;
        }
        public override string ToString()
        {
            return String.Format("{0,-10}Cost: {1,6:C} On hand: {2}",name, cost, onhand); ;
        }
    }
    internal class Program
    {
        static void Main(string[] args)
        {
            List<Product> inv = new List<Product>();
            inv.Add(new Product("A", 5.9, 3));
            inv.Add(new Product("B", 8.2, 2));
            inv.Add(new Product("C", 3.5, 4));
            inv.Add(new Product("D", 1.8, 8));
            Console.WriteLine("Product list: ");
            foreach(Product p in inv)
            {
                Console.WriteLine(" "+ p);
            }
            Console.ReadLine();
        }
    }
}
