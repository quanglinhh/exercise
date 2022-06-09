using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Part4_ex1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            
            //Enter the number of atom add
            Console.Write("Enter the number of atom you wan to add(number <= 10): ");
            int number = int.Parse(Console.ReadLine());
            while (number > 10)
            {
                Console.WriteLine("number > 10, please re-enter!");
                Console.Write("Enter the number of atom you wan to add(number <= 10): ");
                number = int.Parse(Console.ReadLine());
            }
            //Create atomList
            ArrayList atoms = new ArrayList(number);
            Console.WriteLine("Atomic Information");
            Console.WriteLine("========================");
            for (int i = 1; i <= number; i++)
            {
                Atom atom = new Atom();
                atom.AddAtom();
                atoms.Add(atom);
            }
            Console.WriteLine("-------------------------------------");
            foreach (Atom atom in atoms)
            {
                Console.WriteLine(atom);
            }
            Console.ReadLine();
        }
    }
}
