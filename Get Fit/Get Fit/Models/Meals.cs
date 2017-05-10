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
    public class Meals
    {
        int mealId { get; set; }
        string melName { get; set; }
        int mealCalories { get; set; }
        int servings { get; set; }
        DateTime publication { get; set; }
        string mealType { get; set; }
        string recommendation { get; set; }
        string dietaryRestrictions { get; set; }
    }
}