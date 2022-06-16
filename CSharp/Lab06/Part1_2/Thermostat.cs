using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Part1_2
{
    internal class Thermostat
    {
        
        public delegate void TemperatureChangeHandler(float newTemperature);

        //Define the event publisher
        private TemperatureChangeHandler _OnTemperatureChange;
        public TemperatureChangeHandler OnTemperatureChange
        {
            get { return _OnTemperatureChange; }
            set { _OnTemperatureChange = value; }
        }
        private float _CurrentTemperarute;
        public float CurrentTemperature
        {
            get { return _CurrentTemperarute; }
            set 
            { 
                if(value != CurrentTemperature)
                {
                    _CurrentTemperarute = value;
                    //Call subscribers
                    if(OnTemperatureChange != null){
                        OnTemperatureChange(value);
                    }
                }
            }
        }
    }
    
}
