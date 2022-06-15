using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Part1_2
{
    internal class Heater
    {
        private float _Temperature;
        public Heater(float temperature)
        {
            _Temperature = temperature;
        }
        public float Temperature
        {
            get { return _Temperature; }
            set { _Temperature = value; }
        }
        public void OnTemperatureChanged(float newTemperature)
        {
            if(newTemperature < Temperature)
            {
                Console.WriteLine("Heater: On");
            }
            else
            {
                Console.WriteLine("Heater: Off");
            }
        }
    }
}
