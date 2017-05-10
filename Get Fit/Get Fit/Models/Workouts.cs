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
    public class Workouts
    {
        int workoutId { get; set; }
        string workoutName { get; set; }
        string workoutType { get; set; }
        int length { get; set; }
    }
}