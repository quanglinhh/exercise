using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace part1_1
{
    internal class Car
    {

        // declare the fields
        public string make;
        public string model;
        public string color;
        public int yearBuilt;
        // define the methods
        public void Start()
        {
            System.Console.WriteLine(model + " started");
        }
        public void Stop()
        {
            System.Console.WriteLine(model + " stopped");
        }

    }
}
