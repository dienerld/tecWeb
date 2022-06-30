module.exports = {
  env: {
    browser: true,
    es2021: true,
  },
  extends: ['eslint:recommended', 'airbnb-base'],
  parser: '@typescript-eslint/parser',
  parserOptions: {
    ecmaFeatures: {
      ts: true,
    },
    ecmaVersion: 'latest',
    sourceType: 'module',
  },
  plugins: ['@typescript-eslint'],
  rules: {
    'import/prefer-default-export': 'off',
    'import/no-unresolved': 'off',
    '@typescript-eslint/explicit-function-return-type': 'off',
    '@typescript-eslint/no-explicit-any': 'off',
    'object-curly-newline': ['error', { consistent: true }],
    'import/extensions': ['off'],
    'no-unused-vars': ['error', { args: 'none' }],
    'no-useless-constructor': 'off',
    'no-empty-function': [
      'error',
      { allow: ['functions', 'arrowFunctions', 'constructors'] },
    ],
  },
  settings: {
    'import/export': {
      typescript: {},
    },
  },
};
