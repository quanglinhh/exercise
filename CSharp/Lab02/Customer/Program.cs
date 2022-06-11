using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Customer;
using Order;

namespace Customer
{
    class GetName
    {
        public static string  GetCusName()
        {
            Console.Write("Enter the Customer Name: ");
            string cusName = Console.ReadLine();
            return cusName;
        }
    }
}
namespace Order
{
    class Grocery
    {
        public  void OderGrocery(string cusName)
        {
            Console.ForegroundColor = ConsoleColor.Yellow;
            Console.WriteLine("{0} has choiced order grocery!",cusName);
            Console.ResetColor();
        }
    }
    class Bakery
    {
        public void  OderBakery(string cusName)
        {
            Console.ForegroundColor = ConsoleColor.Yellow;
            Console.WriteLine("{0} has choiced order Bakery!", cusName);
            Console.ResetColor();
        }
    }
}
namespace OrderTest
{
    internal class Program
    {
        
        static void Main(string[] args)
        {
            string cusName = GetName.GetCusName();
            Menu(cusName);
            Choice(cusName);
        }
        public static void Choice(string cusName)
        {
            
            int choice = Convert.ToInt32(Console.ReadLine());
            try
            {
                if (choice == 1)
                {
                    Grocery grocery = new Grocery();
                    grocery.OderGrocery(cusName);
                }
                else if (choice == 2)
                {
                    Bakery bakery = new Bakery();
                    bakery.OderBakery(cusName);
                }
                else
                {
                    
                    Console.ForegroundColor = ConsoleColor.Red;
                    Console.WriteLine("Sai cu phap!");
                    Console.WriteLine("Nhap sai!");
                    Console.ResetColor();
                    Menu(cusName);
                    Choice(cusName);
                }
            }
            catch (FormatException ex)
            {
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine("Sai cu phap!");
                Console.WriteLine("Nhap sai!");
                Console.ResetColor();
            }
            finally
            {
                if(choice != 1 && choice != 2)
                {
                    Menu(cusName);
                    Choice(cusName);
                }
                
            }
            Console.ReadLine();
        }
        public static void Menu(string cusName)
        {
            Console.WriteLine("Hello {0}",cusName);
            Console.WriteLine("========Menu===========");
            Console.WriteLine("1. Order Grocery");
            Console.WriteLine("2. Order Bakery");
            Console.Write("Enter your order: ");
            
        }
    }
}