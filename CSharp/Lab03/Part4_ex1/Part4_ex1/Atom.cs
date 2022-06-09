using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Part4_ex1
{
    internal class Atom
    {
        //Fields
        private int atomNumber;
        private string atomSymbol;
        private string atomName;
        private double atomWeight;
        //getter and setter
        public void SetAtomNumber(int atomNumber)
        {
            this.atomNumber = atomNumber;
        }
        public void SetAtomSymbol(string atomSymbol)
        {
            this.atomSymbol = atomSymbol;
        }
        public void SetAtomName(string atomName)
        {
            this.atomName = atomName;
        }
        public void SetAtomWeight(double atomWeight)
        {
            this.atomWeight = atomWeight;
        }
        public int GetAtomNumber()
        {
            return atomNumber;
        }
        public string GetAtomSymbol()
        {
            return atomSymbol;
        }
        public string GetAtomName()
        {
            return atomName;
        }
        public double GetAtomWeightr()
        {
            return atomWeight;
        }
        //Constuctor
        public Atom(int atomNumber, string atomSymbol, string atomName, double atomWeight)
        {
            this.atomNumber = atomNumber;
            this.atomSymbol = atomSymbol;
            this.atomName = atomName;
            this.atomWeight = atomWeight;
        }
        public Atom()
        {

        }
        public void AddAtom()
        {
           
            Console.Write("Enter atomic number : ");
            atomNumber = int.Parse(Console.ReadLine());
            Console.Write("Enter symbol :");
            atomSymbol = Console.ReadLine();
            Console.Write("Enter full name :");
            atomName = Console.ReadLine();
            Console.Write("Enter atomic weight :");
            atomWeight = double.Parse(Console.ReadLine());
        }
        public override string ToString()
        {
            return +atomNumber+" "+atomSymbol+ " "+atomName + " " + atomWeight;
        }

    }
}
