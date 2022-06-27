using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProductManager
{
    internal class Product
    {
        public string ProductId { get; set; }
        public string Name { get; set; }
        public double Price { get; set; }

        public Product(string productId, string name, double price)
        {
            ProductId = productId;
            Name = name;
            Price = price;
        }
        public override string ToString()
        {
            return $"ProductId: {ProductId} -- ProductName: {Name} -- Price: {Price}";
        }
    }
}
