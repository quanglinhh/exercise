using ShoppingMobile.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ShoppingMobile.Controllers
{
    public class ShoppingCartController : Controller
    {
        // GET: ShoppingCart
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult MyOrder()
        {
            return View( (List<Mobile>) Session["cart"] );
        }

        public ActionResult Remove( Mobile moToRemove )
        {
            List<Mobile> li = (List<Mobile>)Session["cart"];
            li.RemoveAll(x => x.slNo == moToRemove.slNo);
            Session["cart"] = li;
            Session["count"] = Convert.ToInt32(Session["count"]) - 1;
            return RedirectToAction("MyOrder", "ShoppingCart");
        }

        public ActionResult AddToCart(Mobile mo)
        {
            //Convert a mobile to mobileItem (with COUNT)
            //Check if item exist, + 1 quantity
            MobileItem item = new MobileItem(mo);

            //Check if Session cart exist
            if (Session["cart"] == null)
            {
                List<Mobile> li = new List<Mobile>();

                li.Add(mo);
                Session["cart"] = li;
                ViewBag.cart = li.Count(); // get all mobile of the Cart

                Session["count"] = 1;
            }
            else
            {
                List<Mobile> li = (List<Mobile>) Session["cart"]; // convert Session of cart to List Mobile
                li.Add(mo);
                Session["cart"] = li;
                ViewBag.cart = li.Count();

                Session["count"] = Convert.ToInt32(Session["count"]) + 1;
            }
            return RedirectToAction("Index", "Home");
        }
    }
}