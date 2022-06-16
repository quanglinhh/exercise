using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Part4_2
{
    internal class Program
    {
        static int GreaterCount(IEnumerable<double> eble, double min)
        {

            //TODO:
            return eble.Where(x => x > min).Count();
        }

        static void Main(string[] args)
        {
            List<double> eble = new List<double>();
            eble.Add(23.5);
            eble.Add(24.5);
            eble.Add(40.5);
            eble.Add(55);
            eble.Add(80);
            
            Console.WriteLine(GreaterCount(eble, 30));
        }
    }
}
