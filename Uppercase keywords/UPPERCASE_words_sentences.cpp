// UPPERCASE_words_sentences.cpp : This file contains the 'main' function. Program execution begins and ends there.

#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <charconv>

using namespace std;

const string INPUT_FILE = "in.txt", OUTPUT_FILE = "out.txt";

typedef vector<int> intArr;

vector<string> split_input() {
	fstream input_file = fstream(INPUT_FILE, fstream::in);
	vector<string> sentences;
	char ch;
	string sentence;

	while (input_file >> noskipws >> ch) {
		sentence.operator+=(ch);
		if (ch == '\n') {
			sentence.pop_back();
			sentences.push_back(sentence);
			sentence = "";
		}	
	}
	sentences.push_back(sentence);
	input_file.close();

	return sentences;
}

vector<string> split(string& source, char Delimeter, bool removeSpaceAfterDelimeter = 0) {
	vector<string> sentences;
	char ch;
	string sentence;
	reverse(source.rbegin(), source.rend());

	bool toggle = false;
	while (source.size() != 0 && (ch = source.back()) != '\0') {

		if (removeSpaceAfterDelimeter && toggle)
			toggle = false;
		else
			sentence.operator+=(ch);
		
		if (ch == Delimeter) {
			sentences.push_back(sentence);
			sentence = "";
			toggle = true; // hit the delimeter
		}

		source.pop_back();
	}

	return sentences;
}

vector<intArr> search(vector<string>& sentences, vector<string>& keywords) {
	vector<intArr> keywords_selected_sentences_indx;

	for (string keyword : keywords) {
		intArr selected_sentences_indecies;
		bool is_keyword_in_sentences;
			
		for (unsigned int i = 0; i < sentences.size(); i++) {
			int startIndex = sentences[i].find(keyword, 0);
			if (startIndex == UINT_MAX)  continue;  // keyword not found

			for (unsigned int j = startIndex; j < startIndex + keyword.size(); j++)
				sentences[i][j] = toupper(sentences[i][j]);
			
			selected_sentences_indecies.push_back(i);
			is_keyword_in_sentences = true;
		}

		if (is_keyword_in_sentences) 
			keywords_selected_sentences_indx.push_back(selected_sentences_indecies);
	}

	return keywords_selected_sentences_indx;
}

void write_to_output(string& str) {
	ofstream output_file;
	output_file.open(OUTPUT_FILE);
	output_file << str;
	output_file.close();
}


int main()
{
	// Get lines from input file
	vector<string> input = split_input();
	
	// Split to sentences
	vector<string> sentences = split(input[0], '.', true);

	// Get count of keywords
	unsigned int keyword_count = std::stoi(input[1]);
	
	// Getting keywords
	vector<string> keywords;
	for (unsigned int i = 0;i < keyword_count;i++) {
		keywords.push_back(input[i + 2]);
	}

	// Get indecies of sentences containing each keyword
	vector<intArr> keywords_selected_sentences_indx = search(sentences, keywords);

	// Print to output file
	string output_string;
	const string newline = "\n";

	for (intArr arr : keywords_selected_sentences_indx) {
		string count = to_string(arr.size());
		output_string.append(count);
		output_string.append(newline);

		for (int i : arr) {
			output_string.append(sentences[i]);
			output_string.append(newline);
		}

		write_to_output(output_string);
	}

}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file

