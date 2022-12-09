using coreShoppingCart.Models;
using coreShoppingCart.Models.DTOs;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;

namespace coreShoppingCart.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;
        MobileShoppingContext db = new MobileShoppingContext();

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        public IActionResult Index()
        {
            List<Mobile> mobiles = db.Mobiles.ToList();
            return View(mobiles);
        }

        [HttpGet]
        [Route("Home/Detail/{slNo:int}")]
        public IActionResult Detail(int slNo) // 7        
        {
            //Get data of Mobile from DB by id = 7
            //LINQ
            var mobileDetail = from m in db.Mobiles
                               join md in db.MobileDetails
                               on m.SlNo equals md.MobileId
                               where m.SlNo == slNo
                               select new MobileDTO
                               {
                                   slno = m.SlNo,
                                   MobileName = m.MobileName,
                                   Price = m.Price,
                                   Url = m.Url,
                                   Features = md.Features,
                                   model = md.Model,
                                   color = md.Color,
                                   SimType = md.SimType
                               };

            List<MobileDTO> dto = mobileDetail.ToList();

            return View( dto );
        }

        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
