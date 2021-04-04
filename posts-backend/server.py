from flask import Flask, json

companies = [
    {"id": "1", "title": "Windows 95 — How Does it Look Today?"},
    {"id": "2", "title": "The Ultimate Interview Prep Guide for Data Scientists and Data Analysts"},
    {"id": "3", "title": "Coinbase Announces Effectiveness of Registration Statement and Anticipated..."},
    {"id": "4", "title": "Whitelist Lottery for Final 3 Genesis NFT Drops"},
    {"id": "5", "title": "How analytics makes football more fun"}
]

api = Flask(__name__)

@api.route('/posts', methods=['GET'])
def get_companies():
  return json.dumps(companies)

if __name__ == '__main__':
    api.run()
