using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExHandling3
{
    internal class MainClass
    {
        public static int AnExCeptionFunction(int value)
        {
            if(value == 0)
            {
                throw new DivideByZeroException("Divide By 0 Error!");
                
            }
            int x = value;
            return x;
        }
        static void Main(string[] args)
        {
            int value = 0;
            try 
            {
                value = AnExCeptionFunction(10);
                Console.WriteLine("Value = {0}",value);
                AnExCeptionFunction(0);
                Console.WriteLine("Value = {0}", value);
            }
            catch(Exception e)
            {
                Console.WriteLine("Caught an exception {0}. Continuing",e);
            }
            Console.WriteLine("Done");
            Console.ReadLine();
        }
    }
}
