using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Part1_2
{
    class Pair<T>
    {
        private T first;
        private T second;

        public Pair(T first, T second)
        {
            this.first = first;
            this.second = second;

        }
        public T First
        {
            get { return first; }
        }
        public T Second
        {
            get { return second; }
        }
    }

    internal class Program
    {

        static void Main(string[] args)
        {
            Pair<string> pair = new Pair<string>("An", "Nga");
            Console.WriteLine("{0},{1}",pair.First,pair.Second);
            Console.ReadLine();
        }
    }
}
