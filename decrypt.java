
    public String generateToken(User user) {
        String payload = user.getUsername() + "&" + user.getPassword();
        char[] letters = secretKey.toCharArray();

        for (int i = 0, j = 0; i < payload.length() & j < letters.length; i++) {
            if (j != letters.length - 1) {
                char ll = (char) (payload.charAt(i) + letters[j]);

                if ((int) ll > 122) { 
                    ll = (char) (ll / 2 + 5);
                    System.out.print((int)(ll) + " ");
                }
                decodedToken.append(ll);
                j++;
            } else {
                j = 0;
            }
        }
        return new String(decodedToken);
    }
