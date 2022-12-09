using ShoppingMobile1.Models;
using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;

namespace ShoppingMobile1.Controllers
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