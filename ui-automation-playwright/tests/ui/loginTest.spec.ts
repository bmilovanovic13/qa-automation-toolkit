import {test, expect} from '@playwright/test';  

test('allows a standard user to log in', async ({ page }) => {
  await page.goto('https://www.saucedemo.com');
  await expect(page.locator('.login_logo')).toHaveText('Swag Labs');
  await page.getByPlaceholder('Username').fill('standard_user');
  await page.getByPlaceholder('Password').fill('secret_sauce');
  await page.getByTestId('login-button').click();
  await expect(page.getByTestId('title')).toHaveText('Products');
});

test('shows an error for a locked-out user', async ({page}) => {
  await page.goto('https://www.saucedemo.com');
  await expect(page.locator('.login_logo')).toHaveText('Swag Labs');
  await page.getByPlaceholder('Username').fill('locked_out_user');
  await page.getByPlaceholder('Password').fill('secret_sauce');
  await page.getByTestId('login-button').click();
  await expect(page.getByRole('alert')).toHaveText('Epic sadface: Sorry, this user has been locked out.');
   await expect(page.getByText('Swag Labs')).toBeVisible();
});

test('shows an error for invalid credentials', async ({page}) => {
  await page.goto('https://www.saucedemo.com');
  await expect(page.locator('.login_logo')).toHaveText('Swag Labs');
  await page.getByPlaceholder('Username').fill('wrong_username');
  await page.getByPlaceholder('Password').fill('secret_sauce');
  await page.getByTestId('login-button').click();
  await expect(page.getByRole('alert')).toHaveText('Epic sadface: Username and password do not match any user in this service');
  await expect(page.locator('.login_logo')).toHaveText('Swag Labs');
});