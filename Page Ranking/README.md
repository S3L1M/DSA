# Page Ranking Algorithm

This Python script implements a simple page ranking algorithm based on various factors such as keyword frequency, the presence of keywords in links, update frequency, last modified date, and more. The goal is to rank a list of websites based on their relevance to a given query.

## How it Works

The script performs the following steps:

1. **Query Input**: Accepts a query from the user, which is a space-separated list of keywords.

2. **Website List**: Defines a list of websites (URLs) to be ranked. You can modify this list to include your preferred websites.

3. **Ranking Calculation**: For each website in the list, the script calculates a ranking score based on the following factors:
   - Number of links on the page that contain the query keywords.
   - Frequency of the query keywords in the page content.
   - Update frequency of the page.
   - Last modified date of the page.
   - Number of non-working links on the page.
   - Page age (in days).
   - Domain age (in days).
   - Page load time.

4. **Output**: The script then displays the list of websites along with their corresponding ranking scores. Additionally, it identifies the website with the highest ranking score, which is considered the most relevant to the query.

## Prerequisites

To run this script, you need the following Python libraries installed:
- `numpy`: For mathematical operations.
- `beautifulsoup4` (BS4): For parsing HTML content.
- `requests`: For making HTTP requests to websites.
- `html2text`: For converting HTML to plain text.
- `nltk`: For natural language processing tasks such as tokenization and frequency distribution.

You can install these libraries using pip:
```
pip install numpy beautifulsoup4 requests html2text nltk
```

## Usage

1. Run the script using Python:
   ```
   python3 page_ranking_algorithm.py
   ```

2. Enter a query when prompted. For example, you can enter a query like "technology gadgets" (without quotes).

3. The script will calculate and display the ranking scores for each website in the list, along with the URL of the website that received the highest ranking.

## Customization

You can customize the following aspects of the script to suit your needs:
- Modify the `websites` list to include the URLs of the websites you want to rank.
- Adjust the factors used in the ranking calculation by changing the values passed to the `rank` function.
- Customize the way the script handles and processes HTML content and keywords to refine the ranking algorithm.

## Example Output

After running the script and providing a query, you will see an output similar to the following:

```
['https://www.souq.com/eg-en', 'https://www.noon.com/egypt-en', 'https://www.jumia.com/', 'https://www.ebay.com/', 'https://www.aliexpress.com/']
[5.231, 3.931, 4.043, 3.112, 2.945]

Most Relevant Website:
https://www.souq.com/eg-en
```

In this example, the script ranks the provided websites based on the given query, and it identifies "https://www.souq.com/eg-en" as the most relevant website. The ranking scores for all websites are displayed.
