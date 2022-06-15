using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Part1_2
{
    internal class Cooler
    {
        private float _Temperature;
        public Cooler(float temperarute)
        {
            _Temperature = temperarute;
        }
        public float Temperarute
        {
            get { return _Temperature; }
            set { _Temperature = value; }
        }
        public void OnTemperatureChanged(float newTemperature)
        {
            if(newTemperature > Temperarute)
            {
                Console.WriteLine("Cooler: On");
            }
            else
            {
                Console.WriteLine("Cooler: Off");
            }
        }
    }
}
