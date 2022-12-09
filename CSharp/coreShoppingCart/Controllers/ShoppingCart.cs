using coreShoppingCart.Models;
using coreShoppingCart.Models.DTOs;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace coreShoppingCart.Controllers
{
    public class ShoppingCart : Controller
    {
        public IActionResult Index()
        {
            return View();
        }

        public IActionResult AddToCart(MobileDTO mo)
        {
            //Session 
            // item + 1
            
            MobileItem item = new MobileItem( mo );
            var obj = JsonConvert.SerializeObject(item);

            //HttpContext.Session.Set("cart", Encoding.ASCII.GetBytes(obj));
            //if (HttpContext.Session.TryGetValue("cart", new byte[]) == null)
            //{
            //    List<Mobile> li = new List<Mobile>();

            //    li.Add(mo);
            //    Session["cart"] = li;
            //    ViewBag.cart = li.Count(); // get all mobile of the Cart

            //    Session["count"] = 1;
            //}
            //else
            //{
            //    List<Mobile> li = (List<Mobile>)Session["cart"]; // convert Session of cart to List Mobile
            //    li.Add(mo);
            //    Session["cart"] = li;
            //    ViewBag.cart = li.Count();

            //    Session["count"] = Convert.ToInt32(Session["count"]) + 1;
            //}
            return RedirectToAction("Index", "Home");


        }
    }
}
