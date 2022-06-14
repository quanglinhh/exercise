
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab5._1
{
    internal class Product
    {
        private int id;
        private string name;
        private string desc;
        private double price;

        public Product(int id, string name, string desc, double price)
        {
            this.id = id;
            this.name = name;
            this.desc = desc;
            this.price = price;
        }

        public Product()
        {
        }
        public int Id { get { return id; } set { id = value; } }
        public string Name { get { return name; } set { name = value; } }

        public double Price { get { return price; } set { price = value; } }

        public string Description { get { return desc; } set { desc = value; } }

        public override string ToString()
        {


            return $"Product name: {name}   |   Product Desc: {desc}   |   Price: {price}";
        }
            
        
    }
}
