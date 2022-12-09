using ShoppingMobile.Models;
using ShoppingMobile.Models.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ShoppingMobile.Controllers
{
    public class HomeController : Controller
    {
        MobileShoppingEntities db = new MobileShoppingEntities();
        public ActionResult Index()
        {
            // Get all mobiles from DB
            List<Mobile> mobiles = db.Mobiles.ToList();

            return View(mobiles);
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }

        public ActionResult EachMobileDetails(Mobile mo)
        {
            //get Mobile DTO from Mobile join with Mobile detail
            var mobileDetail = from m in db.Mobiles
                               join md in db.MobileDetails
                               on m.slNo equals md.MobileId
                               where m.slNo == mo.slNo
                               select new MobileDTO
                               {
                                   slno = m.slNo,
                                   MobileName = m.MobileName,
                                   Price = m.Price,
                                   Url = mo.url,
                                   Features = md.Features,
                                   model = md.Model,
                                   color = md.Color,
                                   SimType = md.SimType
                               };

             List<MobileDTO> dto = mobileDetail.ToList();

             return View( dto );
          
        }
    }
}