// UPPERCASE_words_sentences.cpp : This file contains the 'main' function. Program execution begins and ends there.
//
#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <utility>

using namespace std;

fstream input_file = fstream("in.txt", fstream::in);

vector<string> split_input() {
	vector<string> sentences;
	vector<string> keywords;
	char ch;
	string sentence;
	string keyword;

	while (input_file >> noskipws >> ch) {
		sentence.operator+=(ch);
		if (ch == '.') {
			sentences.push_back(sentence);
			sentence = "";
		}

		if (ch == '\n')
			keyword.operator+=(ch);
		sentences.push_back(keyword);
		keyword = "";

		/*for (int i = 0;i < (int)ch;i++) {
			keyword.operator+=(ch);
			if (ch == '\n') {
				sentences.push_back(keyword);
				keyword = "";
			}
		}*/
	}

	return sentences;//pair<sentences, keywords>;
}


int main()
{
	// Get sentences from input file
	vector<string> sentences = split_input();

	// Get number of searching words
	int x;
	string str = "SHOUD";
	//input_file.seekg(8);
	std::streamsize s = 64;
	//istream stream = input_file.ignore('\n', 1);
	//ch = fstream::getline(input_file.ignore(1)._Stdstr, 8);

	char chararray[10];
	cout << "Type 'abcdef': ";
	//input_file.ignore(8, '\r\n');
	input_file >> noskipws >> chararray;
	cout << chararray << endl << endl;

	for (string var : sentences) {
		cout << var << endl;
	}
	cout << endl;
	cout << str << endl;

	input_file.close();

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
