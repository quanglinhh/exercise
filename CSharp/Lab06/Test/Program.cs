using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int[] scores = { 97, 92, 81, 60 };
            var scorequery = from score in scores where score > 80 select score;
            var scorequery2 = scores.Where(score => score > 80);
            foreach(int i in scorequery2)
            {
                Console.WriteLine(i);
            }
            string[] names = { "Linh" ,"name"};
            var query = from name in names where name[0] == 'L' select name;
            foreach(string n in query)
            {
                Console.WriteLine(n);
            }
            Console.ReadLine();
        }
    }
}
