using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;

namespace Get_Fit.Models
{
    public class Users
    {
        int userId { get; set; }
        string firstName { get; set; }
        string lastName { get; set; }
        int weight { get; set; }
        double height { get; set; }
        Spinner bodyGoal { get; set; }
    }
}