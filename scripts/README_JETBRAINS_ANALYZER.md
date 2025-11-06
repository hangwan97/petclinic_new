# JetBrains GitHub Copilot Plugin Reviews Analyzer

This script analyzes customer reviews from the JetBrains GitHub Copilot plugin page and generates comprehensive reports with visualizations.

## Features

- **Web Scraping**: Automatically fetches reviews from the JetBrains plugin marketplace using Selenium
- **Smart Categorization**: Analyzes and categorizes reviews into:
  - Features (Code Completion, Chat/Edit, Agent, MCP, Inline Chat, Security, Others)
  - Bugs (Performance, UX, Crashes, Reliability)
  - Feature Parity Requests (Custom Instructions, Model Support, Agent Mode, MCP, NES, etc.)
- **Visualizations**: Generates three charts:
  - Line chart showing number of comments by month
  - Pie chart showing distribution of comments by feature
  - Bar chart showing star rating distribution (1-5)
- **Comprehensive Reports**:
  - Markdown summary with all analysis results
  - JSON file with structured data for further processing

## Requirements

- Python 3.7+
- Required packages (listed in `requirements.txt`):
  - matplotlib>=3.10.0
  - selenium>=4.0.0
  - webdriver-manager>=4.0.0

## Installation

1. Install dependencies:
```bash
cd petclinic_new
pip3 install -r requirements.txt
```

2. Make the script executable (optional):
```bash
chmod +x scripts/analyze_jetbrains_reviews.py
```

## Usage

Run the script from the project root directory:

```bash
python3 scripts/analyze_jetbrains_reviews.py
```

Or if made executable:

```bash
./scripts/analyze_jetbrains_reviews.py
```

## Output

The script creates a `jetbrains_view` directory in the project root containing:

1. **review_summary.md** - Comprehensive markdown report with:
   - Overview statistics
   - Visualizations
   - Feature breakdown
   - Star distribution
   - Bug analysis
   - Feature parity requests

2. **review_data.json** - Structured JSON data including:
   - Metadata (generation time, source URL, statistics)
   - All reviews with ratings and dates
   - Categorized reviews
   - Statistical distributions

3. **comments_by_month.png** - Line chart showing comment volume over time

4. **comments_by_feature.png** - Pie chart showing feature distribution

5. **star_distribution.png** - Bar chart showing rating distribution

## How It Works

1. **Fetch Reviews**: Uses Selenium WebDriver to scrape reviews from the JetBrains plugin page
   - Automatically handles popups (accepts/clicks OK when prompted)
   - Scrolls to load more reviews
   - Falls back to sample data if web access is unavailable

2. **Categorize Content**: Uses keyword matching to classify reviews:
   - **Features**: Identifies mentions of specific features
   - **Bugs**: Detects performance issues, UX problems, crashes, and reliability concerns
   - **Feature Parity**: Identifies requests for features from other platforms

3. **Generate Visualizations**: Creates publication-quality charts using matplotlib

4. **Create Reports**: Generates both human-readable and machine-readable outputs

## Customization

You can modify the categorization keywords in the `JetBrainsReviewAnalyzer` class:

- `feature_keywords`: Add/modify feature categories
- `bug_keywords`: Add/modify bug categories  
- `parity_keywords`: Add/modify feature parity categories

## Troubleshooting

### Web Scraping Issues

If the script cannot access the web page:
- Check your internet connection
- The script will automatically fall back to generating sample data for demonstration
- Sample data demonstrates the full functionality of the analysis pipeline

### Selenium/ChromeDriver Issues

The script uses `webdriver-manager` to automatically download and manage ChromeDriver. If you encounter issues:
- Ensure Chrome/Chromium is installed on your system
- Check that you have sufficient permissions
- Try running with `--headless=new` flag if the default headless mode fails

## Example Output Structure

```
jetbrains_view/
├── review_summary.md          # Main report
├── review_data.json          # Structured data
├── comments_by_month.png     # Time series chart
├── comments_by_feature.png   # Feature distribution
└── star_distribution.png     # Rating distribution
```

## Notes

- The script is designed to handle various review formats and gracefully fall back to sample data
- All dates are stored in ISO format for consistency
- Charts are saved at 300 DPI for high-quality output
- The script automatically creates the output directory if it doesn't exist
