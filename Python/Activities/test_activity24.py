import pytest

@pytest.mark.parametrize("earned, spent,expected",[(30,10,20),(20,2,18)])
def test_transaction(wallet_amount,earned,spent,expected):
    # user adds earned money to wallet
    wallet_amount+=earned
    print(wallet_amount)

    #user spends some money
    wallet_amount-=spent
    print(wallet_amount)

    #assert left over amount
    assert wallet_amount==expected
