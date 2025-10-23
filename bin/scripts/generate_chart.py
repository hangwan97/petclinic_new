#!/usr/bin/env python3
"""
Chart generation script for individual point tracking over time.
This script generates a line chart showing point totals for each individual per week.
"""

import matplotlib.pyplot as plt
import matplotlib.dates as mdates
from datetime import datetime, timedelta
import json
import os
import sys

def generate_sample_data():
    """Generate sample data for demonstration purposes."""
    individuals = [
        {"name": "Alice", "color": "#FF6B6B"},
        {"name": "Bob", "color": "#4ECDC4"},
        {"name": "Charlie", "color": "#45B7D1"},
        {"name": "Diana", "color": "#FFA726"},
        {"name": "Eve", "color": "#AB47BC"}
    ]
    
    # Generate 12 weeks of data
    start_date = datetime(2024, 1, 1)
    data = []
    
    for individual in individuals:
        points = 0
        for week in range(12):
            week_date = start_date + timedelta(weeks=week)
            # Simulate varying point accumulation
            if individual["name"] == "Alice":
                points += 15 + (week * 2) + (week % 3 * 5)
            elif individual["name"] == "Bob":
                points += 12 + (week * 3) + (week % 2 * 3)
            elif individual["name"] == "Charlie":
                points += 18 + (week * 1) + (week % 4 * 7)
            elif individual["name"] == "Diana":
                points += 10 + (week * 4) + (week % 5 * 2)
            else:  # Eve
                points += 20 + (week * 2) + (week % 3 * 4)
            
            data.append({
                "individual": individual["name"],
                "color": individual["color"],
                "week": week_date.strftime("%Y-W%U"),
                "date": week_date.isoformat(),
                "cumulative_points": points
            })
    
    return data

def create_line_chart(data, output_path="point_tracking_chart.png"):
    """Create a line chart from the data."""
    plt.style.use('default')
    fig, ax = plt.subplots(figsize=(12, 8))
    
    # Group data by individual
    individuals_data = {}
    for record in data:
        name = record["individual"]
        if name not in individuals_data:
            individuals_data[name] = {
                "dates": [],
                "points": [],
                "color": record["color"]
            }
        individuals_data[name]["dates"].append(datetime.fromisoformat(record["date"]))
        individuals_data[name]["points"].append(record["cumulative_points"])
    
    # Plot lines for each individual
    for name, person_data in individuals_data.items():
        ax.plot(person_data["dates"], person_data["points"], 
                color=person_data["color"], marker='o', linewidth=2.5, 
                markersize=6, label=name)
    
    # Customize the chart
    ax.set_xlabel('Time (Weeks)', fontsize=12, fontweight='bold')
    ax.set_ylabel('Cumulative Points', fontsize=12, fontweight='bold')
    ax.set_title('Individual Point Tracking Over Time', fontsize=16, fontweight='bold', pad=20)
    
    # Format x-axis to show weeks
    ax.xaxis.set_major_formatter(mdates.DateFormatter('%Y-W%U'))
    ax.xaxis.set_major_locator(mdates.WeekdayLocator(interval=2))
    plt.xticks(rotation=45)
    
    # Add grid for better readability
    ax.grid(True, alpha=0.3, linestyle='--')
    
    # Add legend
    ax.legend(loc='upper left', frameon=True, fancybox=True, shadow=True)
    
    # Improve layout
    plt.tight_layout()
    
    # Save the chart
    plt.savefig(output_path, dpi=300, bbox_inches='tight', 
                facecolor='white', edgecolor='none')
    plt.close()
    
    print(f"Chart saved to: {output_path}")

def save_data_as_json(data, output_path="point_data.json"):
    """Save the generated data as JSON for reference."""
    with open(output_path, 'w') as f:
        json.dump(data, f, indent=2)
    print(f"Data saved to: {output_path}")

def main():
    """Main function to generate the chart."""
    print("Generating individual point tracking chart...")
    
    # Generate sample data
    data = generate_sample_data()
    
    # Create output directory if it doesn't exist
    output_dir = "charts"
    os.makedirs(output_dir, exist_ok=True)
    
    # Generate chart
    chart_path = os.path.join(output_dir, "individual_points_line_chart.png")
    create_line_chart(data, chart_path)
    
    # Save data for reference
    data_path = os.path.join(output_dir, "point_tracking_data.json")
    save_data_as_json(data, data_path)
    
    print("Chart generation completed successfully!")
    print(f"Chart location: {chart_path}")
    print(f"Data location: {data_path}")

if __name__ == "__main__":
    main()